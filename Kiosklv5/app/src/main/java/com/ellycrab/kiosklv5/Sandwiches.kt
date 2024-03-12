package com.ellycrab.kiosklv5

class Sandwiches:Food {
    override val foodOptions: List<Pair<String, Double>> = listOf(
        "Egg Slice" to 3000.0,
        "Italian BMT" to 6500.0,
        "Chicken Bacon Avocado" to 7000.0,
        "Rotisserie Barbecue" to 8000.0,
        "Shrimp" to 6500.0,
        "Roasted Chicken" to 8000.0
    )

    override val categoryName: String = "Sandwiches"

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