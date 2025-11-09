package ru.kotlinstudy.main.homework3

interface Transport {
    val name: String
    val maxDistance: Int
    val maxCargo: Int

    fun drive(distance: Int)
    fun loadCargo(weight: Int)
}

abstract class AbstractTransport(
    final override val name: String,
    override val maxDistance: Int,
    override val maxCargo: Int
) : Transport {

    init {
        println("Создан транспорт: $name")
    }

    override fun drive(distance: Int) {
        println(if (distance <= maxDistance) "$name проехала $distance км." else "$name не может проехать $distance км. Максимальная дистанция: $maxDistance км.")
    }

    override fun loadCargo(weight: Int) {
        println(if (weight <= maxCargo) "$name загрузил $weight кг груза." else "$name не может загрузить $weight кг. Максимальный груз: $maxCargo кг.")
    }
}

class Car(name: String) : AbstractTransport(name, 500, 5000)
class Plane(name: String) : AbstractTransport(name, 10000, 100000)

fun main() {
    val transports: Array<Transport> = arrayOf(
        Car("Лада"),
        Plane("Боинг"),
        Car("Toyota"),
        Plane("Airbus")
    )

    println()

    transports.forEach { transport ->
        transport.drive(100)
        transport.loadCargo(1000)
        println()
    }

    val carLada = transports[0] as Car
    val planeBoeing = transports[1] as Plane

    carLada.drive(1100)
    planeBoeing.loadCargo(500)
}