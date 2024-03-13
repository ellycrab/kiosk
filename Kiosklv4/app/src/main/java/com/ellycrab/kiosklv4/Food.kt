package com.ellycrab.kiosklv4

interface Food {

    //대분류 메뉴
    val categoryName:String
    //소분류 메뉴
    val foodOptions:List<Pair<String,Double>>


    fun displayOptions()
    fun orderItem(choice:Int):Pair<String,Double>?
}