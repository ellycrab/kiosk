import com.ellycrab.kiosklv5.Customer
import com.ellycrab.kiosklv5.Food
import com.ellycrab.kiosklv5.Salads
import com.ellycrab.kiosklv5.Sandwiches
import com.ellycrab.kiosklv5.Wraps
import java.util.Calendar
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    // 초기 자본 세팅
    val customer = Customer(20000.0)
    val menus: List<Food> = init()
    var orderCount = 0

    // 5초마다 현재 주문 대기수를 출력하는 스레드 시작
    val orderCountThread = Thread {
        while (true) {
            println("현재 주문 대기수: $orderCount")
            Thread.sleep(5000) // 5초
        }
    }
    orderCountThread.start()

    while (true) {
        println("서브웨이 메뉴:")
        println("1. Salads(Egg Slice, Spicy Shrimp, Spicy Italian, Steak Cheese, Chicken Bacon, KBBQ)")
        println("2. Sandwiches(Egg Slice, Italian BMT, Chicken Bacon Avocado, Rotisserie Barbecue, Shrimp, Roasted Chicken)")
        println("3. Wraps(Steak Wrap, Egg Mayo, Chicken Bacon)")
        println("0. 프로그램 종료")
        println("80. 입금")

        print("1~3,80 번호 중 하나를 선택해주세요: ")

        when (val categoryChoice = readLine()?.toIntOrNull()) {
            in 1..3 -> {
                val menuCategory = menus[categoryChoice?.minus(1)!!]
                orderSebuItem(menuCategory, customer.balance)
            }
            0 -> {
                println("프로그램을 종료합니다.")
                return
            }
            80 -> {
                print("입금할 금액을 입력하세요: ")
                val depositAmount = readLine()?.toDoubleOrNull()
                if (depositAmount != null) {
                    customer.deposit(depositAmount)
                } else {
                    println("잘못된 입력. 유효한 금액을 입력하세요.")
                }
            }
            else -> {
                // 숫자 이외에 다른 것을 선택했을 때
                println("유효하지 않은 카테고리 선택입니다.")
                orderCount++
            }
        }
    }
}

fun orderSebuItem(menuCategory: Food, customerBalance: Double) {
    menuCategory.displayOptions()
    print("세부 메뉴를 선택해주세요. (1-${menuCategory.foodOptions.size}): ")
    val itemChoice = readLine()?.toIntOrNull()

    itemChoice?.let {
        val orderedItem = menuCategory.orderItem(it)

        orderedItem?.let {
            if (customerBalance >= it.second) {
                // 충분한 잔액이 있는 경우 주문 진행
                println("당신의 주문입니다 => $it")
                println("주문 후 잔액: ${customerBalance - it.second}")
            } else {
                // 잔액 부족
                println("잔액이 부족합니다. 주문을 완료할 수 없습니다.")
            }
        } ?: println("유효하지 않은 세부 선택입니다.")
    } ?: println("유효하지 않은 입력입니다.")

    // 주문이 완료된 후 시간을 출력하는 코드 추가
    val currentTime = System.currentTimeMillis()
    println("주문이 완료되었습니다. 현재 시간: $currentTime")
}

// 지연된 작업을 수행하기 위한 함수 추가
// 3초 뒤에 작업을 수행하기 위해 다음 함수를 호출
fun performDelayedTask(delaySeconds: Long, task: () -> Unit) {
    val executor = Executors.newSingleThreadScheduledExecutor()
    executor.schedule(task, delaySeconds, TimeUnit.SECONDS)
    println("$delaySeconds 초 후에 실행된 작업")
}

// 특정 시간의 밀리초를 계산하는 함수
fun calculateSpecificTimeMillis(hour: Int, minute: Int, second: Int): Long {
    val calendar = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, second)
        set(Calendar.MILLISECOND, 0)
    }
    return calendar.timeInMillis
}

// 특정 시간까지의 지연을 계산하는 함수
fun calculateDelay(targetTimeMillis: Long): Long {
    val currentTimeMillis = System.currentTimeMillis()
    return if (targetTimeMillis > currentTimeMillis) {
        // 특정 시간까지의 지연을 계산
        (targetTimeMillis - currentTimeMillis) / 1000
    } else {
        // 이미 지난 시간인 경우 0을 반환하여 즉시 실행
        0
    }
}

fun init(): List<Food> {
    return listOf(Salads(), Sandwiches(), Wraps())
}
