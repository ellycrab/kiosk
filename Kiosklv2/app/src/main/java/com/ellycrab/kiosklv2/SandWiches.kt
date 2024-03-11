package com.ellycrab.kiosklv2

class SandWiches {

    //샌드위치 프로퍼티
    val sandwichOptions = listOf("Egg Slice", "Italian BMT", "Chicken Bacon Avocado",
        "Rotisserie Barbecue", "Shrimp", "Roasted Chicken")


    //샌드위치 메서드

    //세부메뉴 전체
    fun displaySandwiches(){
        println("샌드위치 세부옵션을 선택해주세요.:")
        sandwichOptions.forEachIndexed{
            index,value->
            println("${index+1}.$value")
        }
    }
    //세부메뉴 선택(주문)
    fun orderSandwich(choice:Int):String?{
        if(choice in 1..sandwichOptions.size){
            return sandwichOptions[choice-1]
        }
        println("유효하지 않은 번호를 선택하셨습니다.")
        return null
    }
}