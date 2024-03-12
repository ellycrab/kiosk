package com.ellycrab.kiosklv5

interface Food {

    val foodOptions:List<Pair<String,Double>>
    val categoryName:String

    fun displayOptions()
    fun orderItem(choice:Int):Pair<String,Double>?
}