package outpostState

class OutpostManager {
    val resources: MutableList<ObservableResource> = mutableListOf()

    init {
        println("Менеджер создан")
    }

    fun addResource(resource: ObservableResource) {
        resources.add(resource)
    }
}