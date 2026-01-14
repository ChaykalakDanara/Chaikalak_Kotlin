interface Movable{
    var speed: Int
    fun move()
    fun  stop(){
        println("Останавливается...")
    }
}
class Car : Movable{
    override var speed = 60
        set(value) {}
    override fun move() {
        println("Едем на машине")
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft : Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете")
        println("Летим со скоростью $speed км/ч")
    }

    override fun stop() = println("Приземляемся..")
}
fun trevel(obj: Movable) = obj.move()
interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name: String) : Worker, Student{
    override fun work() = println("$name работает")
    override fun study() = println("$name учиться")
}
fun main(){
    val car: Movable = Car()
    val aircraft: Movable = Aircraft()
//    car.move()
//    aircraft.move()
//    aircraft.stop()
//    trevel(obj = car)
//    trevel(obj = aircraft)
    val pavel = WorkingStudent(name = "Pavel")
    pavel.work()
    pavel.study()
}
