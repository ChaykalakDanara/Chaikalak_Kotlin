package outpostState
import java.io.File

object StateStorage {
    private const val FILE_NAME = "state.txt"
    fun save(resources: List<ObservableResource>) {
        val file = File(FILE_NAME)
        val content = resources.joinToString("\n") { "${it.name},${it.amount}" }
        file.writeText(content)
        println("Сохранено")
    }
    fun load(): List<ObservableResource> {
        val file = File(FILE_NAME)
        if (!file.exists()) return emptyList()

        return file.readLines().map {
            val parts = it.split(",")
            ObservableResource(parts[0], parts[1].toInt())
        }
    }
}