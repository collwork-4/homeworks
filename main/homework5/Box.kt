package ru.kotlinstudy.main.homework5


class Box<T, U, V>(
    private val first: T,
    private val second: U,
    private val third: V
) {
    fun getSum(): Double {
        var sum = 0.0

        if (first is Number) sum += first.toFloat()
        if (second is Number) sum += second.toFloat()
        if (third is Number) sum += third.toFloat()

        return sum
    }
}

fun main() {
    val firstBox = Box("text", 10, 5.5F)
    val secondBox = Box(20, 3.14, "text 2")
    val thirdBox = Box(7.5F, "text 3", 15)

    val totalSum = firstBox.getSum() + secondBox.getSum() + thirdBox.getSum()
    println("\nСумма всех переданных в коробки чисел: $totalSum")
}