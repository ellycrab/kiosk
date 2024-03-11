package com.ellycrab.kiosklv3

open class Food(val foodOptions:List<String>,val foodCategory: String) {

    fun displayOptions(){
        println("$foodCategory 카테고리 선택:")
        foodOptions.forEachIndexed {
                index, value ->
            println("${index+1}.$value")
        }
    }

    open fun orderItem(choice:Int):String?{
        if(choice in 1..foodOptions.size){
            return foodOptions[choice-1]
        }
        return null
    }
}