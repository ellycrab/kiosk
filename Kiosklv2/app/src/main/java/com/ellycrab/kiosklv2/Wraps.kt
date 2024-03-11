package com.ellycrab.kiosklv2

class Wraps {

    //랩 프로퍼티
    val wrapOptions = listOf("Steak Wrap", "Egg Mayo", "Chicken Bacon")

    //랩 메서드

    //세부메뉴 전체
    fun displayWraps(){
        println("랩 세부옵션을 선택해주세요.:")
        wrapOptions.forEachIndexed{
                index,value ->
            println("${index+1}.$value")
        }
    }


    //세부메뉴 선택(주문)
    fun orderWrap(choice:Int):String?{
        if (choice in 1..wrapOptions.size){
            return wrapOptions[choice-1]
        }
        println("유효하지 않은 번호를 선택하셨습니다.")
        return null
    }

}