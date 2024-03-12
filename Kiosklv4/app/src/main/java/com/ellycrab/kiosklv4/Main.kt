
import com.ellycrab.kiosklv4.Customer
import com.ellycrab.kiosklv4.Food
import com.ellycrab.kiosklv4.Salads
import com.ellycrab.kiosklv4.Sandwiches
import com.ellycrab.kiosklv4.Wraps
import java.lang.Exception

fun main(){
    //초기 자본 세팅
    val customer = Customer(20000.0)
    val menus: List<Food> = init()




    while(true){
        println("서브웨이 메뉴:")
        println("1. Salads(Egg Slice, Spicy Shrimp, Spicy Italian, Steak Cheese, Chicken Bacon, KBBQ)")
        println("2. Sandwiches(Egg Slice, Italian BMT, Chicken Bacon Avocado, Rotisserie Barbecue, Shrimp, Roasted Chicken)")
        println("3. Wraps(Steak Wrap, Egg Mayo,Chicken Bacon)")
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
                // 잔액충분
                println("당신의 주문입니다 => $it")
                println("주문 후 잔액: ${customerBalance - it.second}")
            } else {
                // 잔액부족
                println("잔액이 부족합니다. 주문을 완료할 수 없습니다.")
            }
        } ?: println("유효하지 않은 세부 선택입니다.")
    } ?: println("유효하지 않은 입력입니다.")
}

fun init(): List<Food> {
    return listOf(Salads(), Sandwiches(), Wraps())
}
