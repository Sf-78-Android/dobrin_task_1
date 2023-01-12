package game.testCharachters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon
import game.settings.Constants

class Rookie : WarriorDecorator() {
    private var health = Constants.TWENTY
    private val attack = Constants.ZERO

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