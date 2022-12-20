package game.interfaces

import game.collections.Weapons

interface BaseWarrior : CanHit, CanReceiveDamage, CanRestoreHp, BaseWeapon {

    val isAlive: Boolean
    var warriorBehind: BaseWarrior?
    val weapons : Weapons
    val getHealth: Int
    val getAttack: Int



    // var weapon: Weapon?
    // fun equipWeapon(weapon: Weapon)
}