package game.interfaces

import game.collections.Weapons

interface BaseWarrior : CanHit, CanReceiveDamage, CanRestoreHp {
    val isAlive: Boolean
    var warriorBehind: BaseWarrior?
    var warriorIfFront: BaseWarrior?
    val weapons : Weapons
    val getHealth: Int
    val getAttack: Int
    fun equipWeapon(weapon: BaseWeapon)
}