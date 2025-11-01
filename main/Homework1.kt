package ru.kotlinstudy.main

// задание 1
val b: Byte = 127
val s: Short = 15000
val i: Int = 500000000
val l: Long = 999999999999999999
val d: Double = 75.0
val f: Float = 15.7F

val bool: Boolean = true
val str: String = "Hello, world"
val c: Char = 'A'

fun main() {
    printMultipleNumbers()
    greet("Артём")
    println(isNumberNegative(2))
    printNumSign(15)
}

// задание 2
fun greet(str: String) {
    println("Привет, $str!")
}

// задание 3
fun isNumberNegative(num: Int): Boolean {
    return num < 0
}

// задание 4
fun printNumSign(num: Int) {
    var state: String = ""

    when {
        num > 0 -> state = "положительное."
        num < 0 -> state = "отрицательное."
    }

    println("Число $num $state")
}

// задание 5
fun printMultipleNumbers() {
    for (i in 1000 downTo 0) {
        if (i % 3 == 0) println(i)
    }
}