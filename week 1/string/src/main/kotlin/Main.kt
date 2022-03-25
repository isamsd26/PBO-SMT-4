fun main() {
    var txt = "Hello World"
    var txt1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" //string length
    var txt2 = "Hello World"
    var txt3 = "Hello World"
    var txt4 = "Hello World"
    var firstName = "John"
    var lastName = "Doe"


    println(txt[0]) // first element/character
    println(txt[2]) // third element/character
    println("The length of the txt string is: " + txt1.length);
    println("----diatas adalah panjang dari txt1--------")
    println(txt2.toUpperCase())   // Outputs "HELLO WORLD"
    println(txt2.toLowerCase())   // Outputs "hello world"
    println("-----diatas adalah fungsi string-----")
    println(txt3.compareTo(txt4))  // Outputs 0 (they are equal)
    println("-----diatas adalah komparasi string-----")
    println(firstName + " " + lastName)
    println("-----diatas adalah rangkaian string-----")
    println("My name is $firstName $lastName")
    println("-----diatas adalah interpolasi string-----")

}