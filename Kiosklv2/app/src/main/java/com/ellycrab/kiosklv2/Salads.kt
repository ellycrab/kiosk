package com.ellycrab.kiosklv2

class Salads {

    //샐러드 프로퍼티
    val saladOptions = listOf("Egg Slice", "Spicy Shrimp", "Spicy Italian",
        "Steak Cheese", "Chicken Bacon", "KBBQ")

    //샐러드 메서드

    //세부메뉴 전체
    fun displaySalads() {
        println("샐러드 세부옵션을 선택해주세요.:")
        saladOptions.forEachIndexed { index, value ->
            println("${index + 1}. $value")
        }
    }


    //세부메뉴 선택(주문)
    fun orderSalad(choice: Int): String? {
        if (choice in 1..saladOptions.size) {
            return saladOptions[choice - 1]
        }
        return null
    }
}