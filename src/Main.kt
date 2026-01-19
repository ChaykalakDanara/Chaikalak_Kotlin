import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun main(){
    val manager = ResourceManager()
    val minerals = OutpostResource(id = 2, name = "Minerals", amount = 300)
    val gas = OutpostResource(id = 1, name = "Gas", amount = 100)
    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусами: $bonus")
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    manager.add(minerals)
    manager.add(gas)
    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 40))
    manager.printAll()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
}