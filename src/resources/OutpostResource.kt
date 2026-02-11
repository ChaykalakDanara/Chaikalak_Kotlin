package resources
import kotlin.properties.Delegates
data class OutpostResource(
    val id: Int,
    val name: String,
    val amountInit: Int){
    override fun toString(): String {
        return "ID: $id name: $name amount: $amount"
    }
    var amount: Int by Delegates.observable(amountInit){_, old, new ->
        println("Ресурс [$name] изменился: $old -> $new")
}
}
fun nain(){
    val gas = OutpostResource(id = 1, name = "Gas", amountInit = 100)
    val mineral = OutpostResource(id = 2, name = "Minerals", amountInit = 250)
    println("Успех вы дабыли допл кол-вл минералов: ${mineral.amount + 50}")
    val bonusMineral = mineral.copy(id = 2, name = "Minerals Bonus", amountInit = mineral.amount + 50)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMineral.toString())
}
