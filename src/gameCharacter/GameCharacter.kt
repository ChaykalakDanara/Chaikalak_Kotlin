package gameCharacter

class GameCharacter(val name: String) {
    var state: CharacterState = CharacterState.Idle
    fun changeState(newState: CharacterState) {
        state = newState
        println("$name перешел в новое состояние")
    }
}