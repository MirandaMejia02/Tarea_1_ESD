interface NumberType {
    fun isPrime(): Boolean
    fun isEven(): Boolean
    fun isOdd(): Boolean
}

class Number(val value: Int) : NumberType {
    override fun isPrime(): Boolean {
        if (value < 2) return false
        for (i in 2 until value) {
            if (value % i == 0) return false
        }
        return true
    }

    override fun isEven(): Boolean {
        return value % 2 == 0
    }

    override fun isOdd(): Boolean {
        return value % 2 != 0
    }
}

fun main() {
    val N = 10 
    var primeCount = 0
    var evenCount = 0
    var oddCount = 0

    for (i in 1..N) {
        val number = Number(i)
        if (number.isPrime()) primeCount++
        if (number.isEven()) evenCount++
        if (number.isOdd()) oddCount++
    }

    println("Prime numbers count: $primeCount")
    println("Even numbers count: $evenCount")
    println("Odd numbers count: $oddCount")
}
