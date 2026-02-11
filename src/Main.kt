import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager
import modules.ModuleResult

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("Успех: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведен ресурс: ${result.resourceName}, количество: ${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println("Недостаточно ресурсов: ${result.resourceName}, нужно: ${result.required}, есть: ${result.available}")
        is ModuleResult.Error -> println("Ошибка: ${result.reason}")
    }
}
object SystemLogger{
    init {
        println("Systemlogger иницилизирован")
    }
    fun log(messge: String){
        println("[LOG] $messge")
    }
}
val logger by lazy {
    SystemLogger
}
fun main(){
    logger.log("Запуск базы")
    val manager = ResourceManager()
    val minerals = OutpostResource(id = 2, name = "Minerals", amountInit = 300)
    val gas = OutpostResource(id = 1, name = "Gas", amountInit = 100)
    val bonus = minerals.copy(amountInit = minerals.amount + 50)
    println("Копия минералов с бонусами: $bonus")
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    manager.add(minerals)
    manager.add(gas)
    manager.add(OutpostResource(id = 1, name = "Minerals", amountInit = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amountInit = 40))
    manager.printAll()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()

    val loadedResource = FileStorage.load()
    loadedResource.forEach { manager.add(it) }
    if (loadedResource.isEmpty()){
        manager.add(OutpostResource(1, "Minerals", 300))
        manager.add(OutpostResource(2, "Gas", 100))
    }
    FileStorage.save(manager.getall())
}