class Employee {
    var lastName: String
    var firstName: String
    var middleName: String
    var position: String
    var email: String
    var phone: String
    var salary: Int
    var age: Int

    init {
        println("Создан новый сотрудник в системе")
    }

    constructor(
        lastName: String,
        firstName: String,
        middleName: String,
        position: String,
        email: String,
        phone: String,
        salary: Int,
        age: Int
    ) {
        this.lastName = lastName
        this.firstName = firstName
        this.middleName = middleName
        this.position = position
        this.email = email
        this.phone = phone
        this.salary = salary
        this.age = age

        validateEmployee()
    }

    constructor(
        lastName: String,
        firstName: String,
        middleName: String,
        position: String,
        email: String,
        phone: String,
        age: Int
    ) : this(lastName, firstName, middleName, position, email, phone, 0, age) {
        println("\nСотрудник принят на испытательный срок")
    }

    private fun validateEmployee() {
        require(salary >= 0) { "Зарплата не может быть отрицательной" }
    }

    fun printInfo() {
        println("ФИО: $lastName $firstName $middleName")
        println("Должность: $position")
        println("Email: $email")
        println("Телефон: $phone")

        val sal = if (salary == 0) "на испытательном сроке" else "$salary руб."
        println("Зарплата: $sal")

        println("Возраст: $age лет")
        println("─".repeat(40))
    }
}

fun main() {
    val employees = arrayOf(
        Employee("Петров", "Алексей", "Иванович", "Менеджер", "petrov@example.ru", "+7 (999) 123-45-67", 60000, 35),
        Employee("Иванова", "Мария", "Сергеевна", "Директор", "ivanova@example.ru", "+7 (999) 234-56-78", 120000, 45),
        Employee("Сидоров", "Дмитрий", "Петрович", "Разработчик", "sidorov@example.ru", "+7 (999) 345-67-89", 80000, 28),
        Employee("Кузнецова", "Ольга", "Владимировна", "Бухгалтер", "kuznetsova@example.ru", "+7 (999) 456-78-90", 55000, 42),
        Employee("Васильев", "Сергей", "Александрович", "Стажер", "vasiliev@example.ru", "+7 (999) 567-89-01", 38)
    )

    println("\nСотрудники старше 40 лет:")

    val emp = employees.filter { it.age > 40 }

    emp.forEach { employee -> employee.printInfo()}

    println("\nВсе сотрудники:")
    employees.forEachIndexed { index, employee ->
        println("${index + 1}. ${employee.lastName} ${employee.firstName} - ${employee.position}")
    }
}