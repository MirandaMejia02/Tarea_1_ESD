interface FizzBuzzLogic {
    fun computeFizzBuzz(number: Int): String
}

class FizzBuzz : FizzBuzzLogic {
    override fun computeFizzBuzz(number: Int): String {
        return when {
            number % 15 == 0 -> "FizzBuzz"
            number % 3 == 0 -> "Fizz"
            number % 5 == 0 -> "Buzz"
            else -> number.toString()
        }
    }
}

fun main() {
    val fizzBuzz = FizzBuzz()
    for (i in 1..100) {
        print("${fizzBuzz.computeFizzBuzz(i)} ")
        if (i % 10 == 0) println() 
    }
}
