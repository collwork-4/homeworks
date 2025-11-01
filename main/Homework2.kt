package ru.kotlinstudy.main

import java.util.*
import kotlin.system.exitProcess

val random = Random()
val scanner: Scanner = Scanner(System.`in`)
val settings = GameSettings()

class GameSettings {
    val ATTEMPTS_EASY: Int = 3
    val ATTEMPTS_NORMAL: Int = 5
    val ATTEMPTS_HARD = 7

    var difficulty: Int = 0
    var randomValue: Int = 0
    var userValue: Int = 0
    var attempts: Int = 0
    var attemptsUser: Int = 0
    var rangeStart: Int = 0
    var rangeEnd: Int = 0
    var fullRange: Int = 0
    var gameStarted: Boolean = false
}

fun main() {
    setDifficulty()
    generateNumber()
    startAttempt()
}

fun setDifficulty() {
    println("Выберите сложность: Лёгкая - 0, Нормальная - 1, Сложная - 2, Настраиваемая - 3")
    val diff = scanner.nextInt()

    if (diff > 3) throw IllegalArgumentException("Ошибка: Такой сложности нет.")

    settings.difficulty = diff

    if (diff == 3) createUserDifficulty()
}

fun createUserDifficulty() {
    println("Количество попыток:")
    settings.attemptsUser = scanner.nextInt()
    scanner.nextLine()

    println("Диапазон значений: [старт-конец]")
    val range = scanner.nextLine()
    if (!range.contains("-")) throw IllegalArgumentException("Ошибка: используйте формат 'старт-конец'")

    val (first, second) = range.split("-")

    val start = first.toIntOrNull() ?: throw IllegalArgumentException("Неверное начальное значение: $first")
    val end = second.toIntOrNull() ?: throw IllegalArgumentException("Неверное конечное значение: $second")

    if (start >= end) throw IllegalArgumentException("Начальное значение ($start) должно быть меньше конечного ($end)")

    settings.rangeStart = start
    settings.rangeEnd = end

    generateNumber()
}

fun getAttemptsValue(): Int {
    var value = 0

    when (settings.difficulty) {
        0 -> value = settings.ATTEMPTS_EASY
        1 -> value = settings.ATTEMPTS_NORMAL
        2 -> value = settings.ATTEMPTS_HARD
        3 -> value = settings.attemptsUser
    }

    return value
}

fun generateNumber() {
    var localValue = 0

    when (settings.difficulty) {
        0 -> localValue = 10
        1 -> localValue = 25
        2 -> localValue = 50
        3 -> localValue = settings.rangeEnd
    }

    settings.fullRange = localValue

    settings.attempts = getAttemptsValue()
    settings.randomValue = random.nextInt(localValue) + settings.rangeStart
}

fun startAttempt() {
    if (!settings.gameStarted) {
        println("Угадайте число в диапазоне от ${settings.rangeStart} до ${settings.fullRange}")
        settings.gameStarted = true
    }
    print("Введите число: ")
    settings.userValue = scanner.nextInt()
    scanner.nextLine()

    settings.attempts--

    checkResult()
}

fun endGame(isWin: Boolean, num: Int) {
    print(if (isWin) "Число угадано: $num." else "Попытки закончились. Правильное число: ${settings.randomValue}")
    println(" Повторить игру еще раз? 1 - да/0 - нет ")

    settings.gameStarted = false

    val input = scanner.nextInt()
    scanner.nextLine()

    if (input == 1) {
        settings.attempts = getAttemptsValue()
        setDifficulty()
        generateNumber()
        startAttempt()
    } else if (input == 0) {
        exitProcess(0)
    }
}

fun checkResult() {
    if (settings.randomValue == settings.userValue) {
        endGame(true, settings.userValue)
        return
    } else if (settings.attempts < 1) {
        endGame(false, settings.userValue)
    }

    val isLower = settings.randomValue < settings.userValue

    val state = if (isLower) "меньше" else "больше"
    val result = "Загаданное число $state чем ${settings.userValue}. Осталось попыток: ${settings.attempts}"

    println(result)

    startAttempt()
}