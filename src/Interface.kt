interface Movable{
    var speed: Int
    var model: String
    var number: String
    fun move()
    fun  stop(){
        println("Останавливается...")
    }
}
class Car(
    override var model: String,
    override var number: String
) : Movable{
    override var speed = 60
        set(value) {}
    override fun move() {
        println("Едем на машине")
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft(
    override var model: String,
    override var number: String
) : Movable{
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
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayable, AudioPlayable{
//    override fun play() = println("Play audio and video")
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
class WorkingStudent(val name: String) : Worker, Student{
    override fun work() = println("$name работает")
    override fun study() = println("$name учиться")
}
fun main(){
    val car = Car(model = "LADA", number = "134LAD")
    val aircraft = Aircraft(model = "Boeing", number = "737")
    val player = MediaPlayer()
    player.play()
//    val car: Movable = Car()
//    val aircraft: Movable = Aircraft()
//    car.move()
//    aircraft.move()
//    aircraft.stop()
//    trevel(obj = car)
//    trevel(obj = aircraft)
    val pavel = WorkingStudent(name = "Pavel")
    pavel.work()
    pavel.study()
    aircraft.move()
    aircraft.stop()
}
