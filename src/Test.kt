var age: Int = 18
    set(value){
        if((value > 0) and (value < 110))
            field = value
    }
data class Item(
    val id: Int,
    val name: String,
    var quantity: Int
){
    override fun toString(): String {
        return "ID: $id name: $name quantity: $quantity"
    }
}
abstract class Human(val name: String){
    abstract var age: Int
    abstract fun hello()
}
class Person(name: String, override var age: Int): Human(name){
    override fun hello(){
        println("My name is $name")
    }
}
abstract class Figure {
    abstract fun perimeter(): Float
    abstract fun area(): Float
}
class Rectangle(val width: Float, val height: Float): Figure(){
    override fun perimeter(): Float {
        return 2 * (width + height)
    }

    override fun area(): Float {
        return width * height
    }
}
fun main(){
    println(age)
    age = 45
    println(age)
    age = -365
    println(age)
    val sword = Item(id = 1, name = "Sword", quantity = 1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())
    val (id, name, quantity) = betterSword
    println("ID: $id\n name: $name\n quantity: $quantity\n")
//    val denis: Human
//    val pavel: Human = Human(name = "Pavel")
    val denis: Person = Person(name = "Denis", age = 20)
    val maksim: Human = Person(name = "Maksim", age = 17)
    denis.hello()
    maksim.hello()
}
