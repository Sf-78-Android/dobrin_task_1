package game.interfaces

import game.enums.FightType
import game.enums.WarriorType
import game.weapons.Weapon

interface BaseWarrior {
    fun hit(opponent : BaseWarrior, fightType: FightType)
    fun receiveDamage(damage : Int)
    fun restoreHp(amountHp : Int)
    val isAlive : Boolean
    var warriorBehind: BaseWarrior?
    val getHealth : Int
    var weapon: Weapon?
    fun equipWeapon(weapon: Weapon)
}