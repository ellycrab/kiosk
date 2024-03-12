package com.ellycrab.kiosklv5

class Salads : Food {
    override val foodOptions: List<Pair<String, Double>> = listOf(
        "Egg Slice" to 3000.0,
        "Spicy Shrimp" to 4000.0,
        "Spicy Italian" to 5000.0,
        "Steak Cheese" to 7000.0,
        "Chicken Bacon" to 10000.0,
        "KBBQ" to 5000.0
    )
    override val categoryName: String = "Salads"

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