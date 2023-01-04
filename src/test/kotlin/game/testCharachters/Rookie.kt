package game.testCharachters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon

class Rookie : WarriorDecorator() {
    private var health = 20
    private val attack = 0

    override fun receiveDamage(damage: Int) {
      health-=damage
    }

    override fun restoreHp(amountHp: Int) {
        health+=amountHp
    }

    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack

    override fun equipWeapon(weapon: BaseWeapon) {
        TODO("Not yet implemented")
    }
}