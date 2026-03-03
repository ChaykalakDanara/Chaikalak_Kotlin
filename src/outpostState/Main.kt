package outpostState

val manager by lazy {
    println("Lazy инициализация")
    OutpostManager()
}

fun main() {
    val manager = manager
    val res1 = ObservableResource("Minerals", 300)
    val res2 = ObservableResource("Gas", 100)

    manager.addResource(res1)
    manager.addResource(res2)
    val observer = ResourceObserver()
    res1.amount = 350
    res2.amount = 150
    observer.onResourceChanged(res1, 300, 350)
    StateStorage.save(manager.resources)

    val loaded = StateStorage.load()
    println("Загружено: ${loaded.size} ресурсов")
}