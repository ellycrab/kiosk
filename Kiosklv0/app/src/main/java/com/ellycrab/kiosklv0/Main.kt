package com.ellycrab.kiosklv0
import java.lang.Exception

//키오스크 lv0
/*
과제 시작전 어떻게 구현할것인지 그려 보는 과정
-요구사항별 상세 기능정의
-사용하면서 발생할 수 있는 예외 사항 고려
-0누르면 종료
[ 필요한 기능 ]
요구사항1: 메인 메뉴판 화면
: 메뉴 선택시 상세 메뉴화면으로 이동
: 잘못된 번호 선택 시 예외처리
: 프로그램 종료을 위한 번호 정의

요구사항2: ~~~
요구사항3: ~~~
요구사항4: ~~~
서브웨이 메뉴로 진행
-종류: sandwich(eggSlice,ItalianBMT,ChickenBaconAvocado,RotisserieBarbecue,Shrimp,RoastedChicken)
, wrap(SteakWrap,EggMayo,ChickenBacon) , salad(EggSlice,SpicyShrimp,SpicyItalian,SteakCheese,ChickenBacon,Kbbq)
 */
fun main() {
    var userInput: String?

    do {
        displayMainMenu()
        userInput = readLine()

        when (userInput) {
            "1" -> orderSandwich()
            "2" -> orderWrap()
            "3" -> orderSalad()
            "0" -> {
                println("프로그램을 종료합니다. 안녕히 계세요!")
                return
            }
            else -> {
                println("잘못된 입력입니다. 올바른 옵션을 선택하세요.")
            }
        }

    } while (true)
}

fun displayMainMenu() {
    println("서브웨이 메뉴:")
    println("1. 샌드위치")
    println("2. 랩")
    println("3. 샐러드")
    println("0. 주문 종료")
    print("원하는 항목을 선택하세요: ")
}

fun orderSandwich() {
    println("샌드위치 종류:")
    println("1. Egg Slice")
    println("2. Italian BMT")
    println("3. Chicken Bacon Avocado")
    println("4. Rotisserie Barbecue")
    println("5. Shrimp")
    println("6. Roasted Chicken")

    print("원하는 샌드위치를 선택하세요: ")
    val sandwichChoice = readLine()

    // 선택된 샌드위치에 대한 로직 추가
}

fun orderWrap() {
    println("랩 종류:")
    println("1. Steak Wrap")
    println("2. Egg Mayo")
    println("3. Chicken Bacon")

    print("원하는 랩을 선택하세요: ")
    val wrapChoice = readLine()

    // 선택된 랩에 대한 로직 추가
}

fun orderSalad() {
    println("샐러드 종류:")
    println("1. Egg Slice")
    println("2. Spicy Shrimp")
    println("3. Spicy Italian")
    println("4. Steak Cheese")
    println("5. Chicken Bacon")
    println("6. KBBQ")

    print("원하는 샐러드를 선택하세요: ")
    val saladChoice = readLine()

    // 선택된 샐러드에 대한 로직 추가
}