package ru.kotlinstudy.main.homework5

fun main() {
    print("Введите строку: ")
    val input = readlnOrNull()

    validateString(input)
    println("Строка не содержит ошибок.")
}

fun validateString(str: String?) {
    str?.let {
        if (it.any { char -> char.isDigit() }) {
            throw IllegalArgumentException("Строка не должна содержать число.")
        }
    }
}