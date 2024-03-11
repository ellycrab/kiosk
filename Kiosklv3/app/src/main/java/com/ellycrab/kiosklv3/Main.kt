package com.ellycrab.kiosklv3
import java.lang.Exception

fun main(){
    val menus:List<Food> = init()

    // 메뉴 초기화
   // menus.forEach { it.displayOptions() }

    while(true){
        println("서브웨이 메뉴:")
        println("1. Salads(Egg Slice, Spicy Shrimp, Spicy Italian, Steak Cheese, Chicken Bacon, KBBQ)")
        println("2. Sandwiches(Egg Slice, Italian BMT, Chicken Bacon Avocado, Rotisserie Barbecue, Shrimp, Roasted Chicken)")
        println("3. Wraps(Steak Wrap, Egg Mayo,Chicken Bacon)")
        println("0. 프로그램 종료")

        print("서브웨이 메뉴 카테고리를 선택해주세요. (1-3): ")
        val categoryChoice = readLine()?.toIntOrNull()

        when (categoryChoice) {
            in 1..3 -> if (categoryChoice != null) {
                orderItem(menus[categoryChoice - 1])
            }
            0 -> {
                println("프로그램을 종료합니다.")
                return
            }
            else -> {
                //숫자이외에 다른것을 선택했을때
                println("유효하지 않은 카테고리 선택입니다.")
            }
        }
    }
}

fun orderItem(menuCategory: Food) {
    menuCategory.displayOptions()
    print("세부 메뉴를 선택해주세요. (1-${menuCategory.foodOptions.size}): ")
    val itemChoice = readLine()?.toIntOrNull()

    val orderedItem = itemChoice?.let { menuCategory.orderItem(it) }

    orderedItem?.let {
        println("당신의 주문입니다 => $it")
    } ?: println("유효하지 않은 세부 선택입니다.")
}

fun init(): List<Food> {
    return listOf(Salads(), Sandwiches(), Wraps())
}
