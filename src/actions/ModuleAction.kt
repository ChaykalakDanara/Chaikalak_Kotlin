package actions
import resources.OutpostResource
import resources.ResourceManager
interface ModuleAction {
    fun execute(manager: ResourceManager)
}