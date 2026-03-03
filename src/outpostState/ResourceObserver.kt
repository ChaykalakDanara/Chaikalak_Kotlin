package outpostState

class ResourceObserver {
    fun onResourceChanged(resource: ObservableResource, oldValue: Int, newValue: Int) {
        println("Наблюдатель: ${resource.name} $oldValue → $newValue")
    }
}