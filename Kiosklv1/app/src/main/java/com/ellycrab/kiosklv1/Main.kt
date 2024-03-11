package com.ellycrab.kiosklv1
import java.lang.Exception

/*
- 프로그램을 실행하면 메뉴판의 번호들을 보여줍니다.(대분류의 메뉴를 보여줌)
- 대분류 메뉴에 해당하는 숫자를 입력하면 선택하면 세부 메뉴들을 보여줍니다.
    - 예를 들어 햄버거에 해당하는 숫자를 입력 하면
    햄버거 1, 햄버거 2 처럼 세부 종류를 보여줘요.(출력 예시 참고)
- `**반복문**`을 이용해서 메뉴 선택할 수 있게 유지하고
대분류 메뉴에서, 0번이 입력되면 프로그램을 종료합니다.
 */

fun main() {
    var userInput: String?

    do {
        displayMainMenu()
        userInput = readLine()

        when (userInput) {
            "1" -> {
                handleMainMenuSelection()
            }
            "2" -> {
                handleRequirement2()
            }
            "3" -> {
                handleRequirement3()
            }
            "4" -> {
                handleRequirement4()
            }
            "0" -> {
                println("프로그램을 종료합니다. 안녕히 계세요!")
                break
            }
            else -> {
                println("잘못된 입력입니다. 올바른 옵션을 선택하세요.")
            }
        }

    } while (true)
}

fun displayMainMenu() {
    println("메인 메뉴:")
    println("1. 요구 사항 1: 메인 메뉴 화면")
    println("2. 요구 사항 2: ~~~")
    println("3. 요구 사항 3: ~~~")
    println("4. 요구 사항 4: ~~~")
    println("0. 종료")
    print("원하는 항목을 선택하세요: ")
}

fun handleMainMenuSelection() {
    println("요구 사항 1: 메인 메뉴 화면 처리 중")
    // 요구 사항 1에 대한 로직을 여기에 구현
}

fun handleRequirement2() {
    println("요구 사항 2 처리 중: ~~~")
    // 요구 사항 2에 대한 로직을 여기에 구현
}

fun handleRequirement3() {
    println("요구 사항 3 처리 중: ~~~")
    // 요구 사항 3에 대한 로직을 여기에 구현
}

fun handleRequirement4() {
    println("요구 사항 4 처리 중: ~~~")
    // 요구 사항 4에 대한 로직을 여기에 구현
}