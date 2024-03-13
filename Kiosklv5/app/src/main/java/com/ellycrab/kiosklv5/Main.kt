import com.ellycrab.kiosklv5.Customer
import com.ellycrab.kiosklv5.Food
import com.ellycrab.kiosklv5.Salads
import com.ellycrab.kiosklv5.Sandwiches
import com.ellycrab.kiosklv5.Wraps
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

const val DELAY_3_SECONDS = 3L
const val PAYMENT_RESTRICTED_START_HOUR = 12
const val PAYMENT_RESTRICTED_END_HOUR = 14

val orderCount = AtomicInteger(0)

fun main() {
    val customer = Customer(20000.0)
    val menus: List<Food> = init()

    val scheduler: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    scheduler.scheduleAtFixedRate({
        println("현재 주문 대기수: ${orderCount.get()}")
    }, 0, 5, TimeUnit.SECONDS)

    while (true) {
        printMenu()
        when (val categoryChoice = readLine()?.toIntOrNull()) {
            in 1..3 -> orderSebuItem(menus[categoryChoice!! - 1], customer.balance)
            0 -> {
                println("프로그램을 종료합니다.")
                scheduler.shutdown()
                return
            }
            80 -> deposit(customer)
            else -> {
                println("유효하지 않은 카테고리 선택입니다.")

            }
        }
    }
}

fun isPaymentAllowed(): Boolean {
    val currentTime = Instant.now()
    val restrictedStartTime = LocalTime.of(PAYMENT_RESTRICTED_START_HOUR, 0)
    val restrictedEndTime = LocalTime.of(PAYMENT_RESTRICTED_END_HOUR, 0)
    val currentLocalTime = currentTime.atZone(ZoneId.systemDefault()).toLocalTime()

    return currentLocalTime.isBefore(restrictedStartTime) || currentLocalTime.isAfter(restrictedEndTime)
}

fun orderSebuItem(menuCategory: Food, customerBalance: Double) {
    menuCategory.displayOptions()
    print("세부 메뉴를 선택해주세요. (${menuCategory.foodOptions.size}): ")
    val itemChoice = readLine()?.toIntOrNull()

    itemChoice?.let {
        val orderedItem = menuCategory.orderItem(it)

        orderedItem?.let {
            if (customerBalance >= it.second) {
                println("당신의 주문입니다 => $it")
                println("주문 후 잔액: ${customerBalance - it.second}")
            } else {
                println("잔액이 부족합니다. 주문을 완료할 수 없습니다.")
            }
        } ?: println("유효하지 않은 세부 선택입니다.")
    } ?: println("유효하지 않은 입력입니다. 3초뒤에 다시 입력해주세요.")

    orderCount.incrementAndGet()

    val currentTime = Instant.now()
    println("주문이 완료되었습니다. 현재 시간: $currentTime")

    performDelayedTask(DELAY_3_SECONDS) {
        println("${DELAY_3_SECONDS}초 후에 다른 주문을 수행할 수 있습니다. 그전에 입력하시면 다시 입력하셔야합니다.")
    }
}

fun deposit(customer: Customer) {
    if (!isPaymentAllowed()) {
        println("지정된 시간대에는 결제가 제한됩니다.")
    } else {
        print("입금할 금액을 입력하세요: ")
        val depositAmount = readLine()?.toDoubleOrNull()
        if (depositAmount != null && depositAmount >= 0) {
            customer.deposit(depositAmount)

            val currentTime = Instant.now()
            println("입금이 완료되었습니다. 현재 시간:$currentTime")

            performDelayedTask(DELAY_3_SECONDS) {
                println("${DELAY_3_SECONDS}초 후에 다른 작업을 수행할 수 있습니다.")
            }
        } else {
            println("잘못된 금액입니다. 유효한 금액을 입력해주세요.")
        }
    }
}

fun performDelayedTask(delaySeconds: Long, task: () -> Unit) {
    val executor = Executors.newSingleThreadScheduledExecutor()
    executor.schedule(task, delaySeconds, TimeUnit.SECONDS)
}

fun init(): List<Food> {
    return listOf(Salads(), Sandwiches(), Wraps())
}

fun printMenu() {
    println("서브웨이 메뉴:")
    println("1. Salads(Egg Slice, Spicy Shrimp, Spicy Italian, Steak Cheese, Chicken Bacon, KBBQ)")
    println("2. Sandwiches(Egg Slice, Italian BMT, Chicken Bacon Avocado, Rotisserie Barbecue, Shrimp, Roasted Chicken)")
    println("3. Wraps(Steak Wrap, Egg Mayo, Chicken Bacon)")
    println("0. 프로그램 종료")
    println("80. 입금")
    print("1~3,80 번호 중 하나를 선택해주세요: ")
}
