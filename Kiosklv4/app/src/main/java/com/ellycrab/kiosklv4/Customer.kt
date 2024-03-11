package com.ellycrab.kiosklv4

class Customer(var balance:Double) {
    private val orders = mutableListOf<Pair<String,Double>>()

    fun displayBalance(){
        println("현재 잔액: $balance")
    }

    //주문
    fun placeOrder(food:Food, choice:Int){
        var orderedItem = food.orderItem(choice)
        if(orderedItem != null){
            orders.add(orderedItem)
            balance -= orderedItem.second
            println("주문: ${orderedItem.first} - 가격: ${orderedItem.second}")
            displayBalance()
        }else{
            println("유효하지 않은 선택입니다. 다시 선택해주세요.")
        }
    }
    //현재 주문한게 뭔지 나타내기
    fun displayOrders() {
        println("당신의 주문입니다.:")
        orders.forEachIndexed { index, (item, price) ->
            println("${index + 1}. $item - 가격: $price")
        }
        displayBalance()
    }
    //입금하기
    fun deposit(amount:Double){
        balance += amount
        println("입금 성공!! 현재잔액:$balance")
    }
}
