package gameCharacter

fun handleCharacterState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Death -> println("Персонаж погиб: ${state.reason}")
    }
}
fun main() {
    val character = GameCharacter("Рон")
    character.changeState(CharacterState.Running)
    handleCharacterState(character.state)
    character.changeState(CharacterState.Attack(damage = 50))
    handleCharacterState(character.state)
    character.changeState(CharacterState.Death(reason = "Упал в лаву"))
    handleCharacterState(character.state)
}