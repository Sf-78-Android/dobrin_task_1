package game.interfaces

import game.enums.FightType

interface BaseWarrior {
    fun hit(opponent : BaseWarrior, fightType: FightType)
    fun receiveDamage(damage : Int)
    fun restoreHp(amountHp : Int)
    val isAlive : Boolean
    var warriorBehind: BaseWarrior?
    val getHealth : Int
}