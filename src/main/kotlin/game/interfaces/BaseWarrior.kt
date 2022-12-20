package game.interfaces

interface BaseWarrior : CanHit, CanHeal, CanReceiveDamage, CanRestoreHp {

    val isAlive: Boolean
    var warriorBehind: BaseWarrior?
    val getHealth: Int
    val getAttack: Int
    val getDefence: Int
    val getVampirism: Int
    val getHealingPower: Int


    // var weapon: Weapon?
    // fun equipWeapon(weapon: Weapon)
}