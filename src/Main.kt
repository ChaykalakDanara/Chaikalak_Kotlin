fun main(){
    val manager = ResourceManager()
    val minerals = OutpostResource(id = 2, name = "Minerals", amount = 300)
    val gas = OutpostResource(id = 1, name = "Gas", amount = 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусами: $bonus")

}