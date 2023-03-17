package machine

const val WATER_NEEDED = 200
const val MILK_NEEDED = 50
const val COFFEE_NEEDED = 15

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val water = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffee = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val requestedCups = readln().toInt()

    val possibleCups = calculateCups(water, milk, coffee)

    when {
        requestedCups == possibleCups -> println("Yes, I can make that amount of coffee")
        requestedCups < possibleCups -> println("Yes, I can make that amount of coffee (and even ${possibleCups - requestedCups} more than that)")
        else -> println("No, I can make only $possibleCups cups of coffee")
    }
}

fun calculateCups(water: Int, milk: Int, coffee: Int): Int {
    return minOf(water / WATER_NEEDED, milk / MILK_NEEDED, coffee / COFFEE_NEEDED)
}
