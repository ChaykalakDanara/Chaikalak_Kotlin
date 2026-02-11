package example
import kotlin.properties.Delegates
interface Base {
    fun someFun()
}
class BaseIml(): Base {
    override fun someFun() {}
}
class Derived(someBase: Base): Base by someBase

interface Messenger{
//    fun send(massage: String)
    fun sendTextMessege()
    fun sendVideoMessege()
}
class InstantMessenger(val programName: String): Messenger{
//    override fun send(message: String) {
//        println("Messege `$message` has been sent")
    override fun sendTextMessege() =println("Send text messege")
    override fun sendVideoMessege() = println("Send video messege")
}
class SmartPhone(val name: String, m: Messenger): Messenger by m{
    fun sendTextMesseger() = println("Send sms")
}
interface PhotoDevice {
    fun takePhoto()
}
class PhotoCamera : PhotoDevice {
    override fun takePhoto() = println("Taking a photo")
}
var counter: Int by Delegates.observable(0){_, old, new ->
    println("Счетчик изменился: $old -> $new")
}
class  User {
    var name: String by Delegates.observable("<no name>"){ _,old,new ->
        println("Имя изменено: '$old' -> '$new'")
    }
}
fun main(){
    val max = InstantMessenger("MAX")
    //val photoCamera = PhotoCamera()
    val yotaPhone = SmartPhone("YotaPhone", m = max)
    yotaPhone.sendTextMesseger()
    yotaPhone.sendVideoMessege()
    counter = 1
    counter = 5
}


