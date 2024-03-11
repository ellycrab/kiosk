package com.ellycrab.kiosklv4

class Wraps:Food {

    override val foodOptions: List<Pair<String, Double>>
        = listOf(
        "Steak Wrap" to 4500.0,
        "Egg Mayo" to 5000.0,
        "Chicken Bacon" to 6000.0
        )
    override val categoryName: String = "Wraps"

    override fun displayOptions() {
        println("$categoryName 옵션:")
        foodOptions.forEachIndexed { index, (item, price) ->
            println("${index + 1}. $item - Price: $price")
        }
    }
    override fun orderItem(choice: Int): Pair<String, Double>? {
        if (choice in 1..foodOptions.size) {
            return foodOptions[choice - 1]
        }
        return null
    }
}