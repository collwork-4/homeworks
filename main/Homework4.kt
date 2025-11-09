package ru.kotlinstudy.main

class Book(
    var title: String = "",
    var author: String = "",
    var rating: Double = 0.0
) {
    override fun toString(): String {
        return "\"$title\" - $author (Рейтинг: $rating)"
    }
}

fun main() {
    val library = mutableListOf<Book>()

    fun addBook(title: String, author: String, rating: Double) {
        val book = Book().apply {
            this.title = title
            this.author = author
            this.rating = rating.coerceIn(0.0, 5.0)
        }
        library.add(book)
        println("Добавлена: $book")
    }

    fun removeBook(title: String): Boolean {
        return library.find { it.title == title }?.let { book ->
            library.remove(book)
            println("Удалена: $book")
            true
        } ?: false
    }

    fun findBook(title: String): Book? {
        return library.find { it.title == title }
    }

    fun printCatalog() {
        library.run {
            println()
            if (isEmpty()) {
                println("Каталог пуст")
            } else {
                println("Каталог книг:")
                forEachIndexed { index, book ->
                    println("${index + 1}. $book")
                }
            }
        }
    }

    fun getAverageRating(): Double {
        return with(library) {
            if (isEmpty()) 0.0 else sumOf { it.rating } / size
        }
    }

    addBook("Война и мир", "Лев Толстой", 4.8)
    addBook("Преступление и наказание", "Федор Достоевский", 4.5)
    addBook("Мастер и Маргарита", "Михаил Булгаков", 4.9)

    printCatalog()

    println("\nПоиск книги...")
    val foundBook = findBook("Война и мир")
    println("Найдена книга: ${foundBook ?: "не найдена"}")

    println("\nСтатистика:")
    println("Средний рейтинг: ${"%.2f".format(getAverageRating())}")
    println("Всего книг: ${library.size}")

    println("\nУдаление книги...")
    removeBook("Преступление и наказание")

    printCatalog()
    println("Средний рейтинг: ${"%.2f".format(getAverageRating())}")
    println("Всего книг: ${library.size}")
}