// Superclass
open class MyParentClass {
    val x = 5
}

// Subclass
class MyChildClass: MyParentClass() {
    fun myFunction() {
        println(x) // x is defined in the superclass
    }
}

// Create an object of the MyChildClass and call myFunction
fun main() {
    val myObj = MyChildClass()
    myObj.myFunction()
}