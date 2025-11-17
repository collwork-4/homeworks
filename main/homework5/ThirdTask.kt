package ru.kotlinstudy.main.homework5

fun main() {
    print("Введите строку: ")
    val input = readlnOrNull()

    try {
        validateString(input)
        println("Строка не содержит ошибок.")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

fun validateString(str: String?) {
    str?.let {
        if (it.any { char -> char.isDigit() }) {
            throw IllegalArgumentException("Строка не должна содержать число.")
        }
    }
}