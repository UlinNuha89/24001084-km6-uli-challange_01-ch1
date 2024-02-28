package DataSource

import Model.FoodMenu

interface FoodMenuDataSource {
    fun getFoodList(): List<FoodMenu>
}

class FoodMenuDataSourceImpl() : FoodMenuDataSource {
    override fun getFoodList(): List<FoodMenu> {
        return listOf(
            FoodMenu(
                name = "Ayam Bakar",
                price = 50000
            ),
            FoodMenu(
                name = "Ayam Goreng",
                price = 40000
            ),
            FoodMenu(
                name = "Ayam Geprek",
                price = 40000
            ),
            FoodMenu(
                name = "Kulit Ayam Crispy",
                price = 15000
            ),
            FoodMenu(
                name = "Sate Usus Ayam",
                price = 5000
            ),
        )
    }
}