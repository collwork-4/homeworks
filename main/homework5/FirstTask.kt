package ru.kotlinstudy.main.homework5

fun main() {
    val strings = arrayOf(1, 2, 3, 4, 5)
    strings.swapElements(0, 2)
    println(strings.contentToString())
}

fun <T> Array<T>.swapElements(in1: Int, in2: Int) {
    if (in1 !in indices || in2 !in indices) throw IllegalArgumentException("Индексы выходят за границы массива")

    val temp = this[in1]
    this[in1] = this[in2]
    this[in2] = temp
}