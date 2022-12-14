package game.interfaces

interface BaseWarrior {
    fun hit(opponent: BaseWarrior)
    fun receiveDamage(damage: Int)
    val isAlive: Boolean
    var warriorBehind: BaseWarrior?
    val getHealth: Int

}