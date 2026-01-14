class OutpostWorker (val name: String){
    var maxEnergy: Int = 100
        set(value){
            field = value.coerceIn(0, maxEnergy)
        }
    var energy: Int = 100
        set(value){
            field = value.coerceIn(0, 100)
        }
    var mood: Int = 50
        get() = field + (energy/10)
    var level: Int = 1
    fun work(){
        println("$name работает...")
        energy -= 15
        if (energy < 20) println("$name устал...")
    }
    fun rest(){
        println("$name отдыхает...")
        energy += 20
    }
    fun levelUp(){
        level++
        maxEnergy +=20
        energy = maxEnergy
        println("$name повышает уровень: $level")
    }
}
fun main(){
    val worker = OutpostWorker(name = "Наташа")
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.energy}")
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.rest()
    worker.energy = 150
    worker.level = 5
    worker.levelUp()
}