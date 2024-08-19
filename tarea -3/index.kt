// Interfaz común para todos los tipos de números
interface IBaseNumber {
    val value: Int
    fun printValue()
}

class PrimeNumber(override val value: Int) : IBaseNumber {
    override fun printValue() {
        println("Número primo: $value")
    }
}

class OddNumber(override val value: Int) : IBaseNumber {
    val divisores = mutableListOf<Int>()

    init {
        divisores.addAll(findDivisors(value))
    }

    override fun printValue() {
        println("Número impar: $value, Divisores: $divisores")
    }

    private fun findDivisors(num: Int): List<Int> {
        return (1..num).filter { num % it == 0 }
    }
}

class EvenNumber(override val value: Int) : IBaseNumber {
    val divisores = mutableListOf<Int>()

    init {
        divisores.addAll(findDivisors(value))
    }

    override fun printValue() {
        println("Número par: $value, Divisores: $divisores")
    }

    private fun findDivisors(num: Int): List<Int> {
        return (1..num).filter { num % it == 0 }
    }
}

class PrimeNumberProcessor(val range: IntRange) {

    fun evaluateNumbers() {
        val primes = mutableListOf<PrimeNumber>()
        val odds = mutableListOf<OddNumber>()
        val evens = mutableListOf<EvenNumber>()

        for (num in range) {
            when {
                isPrime(num) -> primes.add(PrimeNumber(num))
                num % 2 == 0 -> evens.add(EvenNumber(num))
                else -> odds.add(OddNumber(num))
            }
        }
 
        primes.forEach { it.printValue() }
        odds.forEach { it.printValue() }
        evens.forEach { it.printValue() }
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2 until num) {
            if (num % i == 0) return false
        }
        return true
    }
}

fun main() {
    val processor = PrimeNumberProcessor(1..20) 
    processor.evaluateNumbers()
}
