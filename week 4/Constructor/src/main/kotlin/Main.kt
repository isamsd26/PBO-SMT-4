class Car(var brand: String, var model: String, var year: Int)

fun main() {
    val c1 = Car("Ford", "Mustang", 1969)
    val c2 = Car("BMW", "X5", 1999)
    val c3 = Car("Tesla", "Model S", 2020)

    println(c1.brand)
    println(c2.brand)
    println(c3.brand)
}