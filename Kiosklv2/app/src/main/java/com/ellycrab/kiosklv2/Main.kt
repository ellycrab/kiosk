package com.ellycrab.kiosklv2
import java.lang.Exception

/*
- 필요한 클래스들을 설계합니다.(버거, 아이스크림, 음료, 맥주, 주문, 공통 등)
- 클래스들의 `**프로퍼티**`와 `**메소드**`를 정의합니다
    - 예를 들어 아래 이미지처럼 클래스 다이어그램을 그려봅시다.
    - 햄버거는 이름, 가격 같은 프로퍼티와 정보를 출력하는 메소드가 있을 수 있죠?
- **`Lv1`**에서 작성한 로직을 메소드로 만듭니다.
 */

fun main(){
    val salads = Salads()
    val sandwiches = SandWiches()
    val wraps = Wraps()


    while(true){
        println("Subway 전체 메뉴")

        println("1. Salads")
        println("2. Sandwiches")
        println("3. Wraps")

        println("1~3번의 메뉴를 선택해주세요.:")

        when(readln()?.toIntOrNull()){
            1->{
                salads.displaySalads()

                val saladChoice = readLine()?.toIntOrNull()
                val orderedSalad = saladChoice?.let { salads.orderSalad(it) }

                orderedSalad?.let{
                    println("당신의 주문은: ${it}")
                }?: println("유효하지 않은 선택입니다.")

            }
            2->{
                sandwiches.displaySandwiches()

                val sandwichChoice = readLine()?.toIntOrNull()
                val orderedSandwich = sandwichChoice?.let { sandwiches.orderSandwich(it) }

                orderedSandwich?.let {
                    println("당신의 주문은:${it}")
                }?: println("유효하지 않은 선택입니다.")

            }
            3->{
                wraps.displayWraps()

                val wrapChoice = readLine()?.toIntOrNull()
                val orderedWrap = wrapChoice?.let { wraps.orderWrap(it) }

                orderedWrap?.let {
                    println("당신의 주문은:${it}")
                } ?: println("유효하지 않은 선택입니다.")

            }
            0->{
                println("프로그램을 종료합니다. byebye")
                break
            }
            else -> {
                println("유효하지않은 카테고리입니다. 다시 선택해주세요.")

            }
        }
    }
}