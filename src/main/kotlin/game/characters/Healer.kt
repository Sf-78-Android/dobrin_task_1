package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.interfaces.CanHeal
import game.settings.Constants
import game.settings.Params

class Healer : WarriorDecorator(), CanHeal {
    private var initialHealth = Params.Healer.HEALTH
    private var health: Int = Params.Healer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var healingPower: Int = Params.Healer.HEALING_POWER
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = Constants.ZERO

    val getHealingPower: Int
        get() = healingPower

    override val isAlive: Boolean
        get() = health > Constants.ZERO


    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth()
        health = initialHealth
        healingPower += weapon.getHealingPower()
    }

    override fun heal(allyInFront: BaseWarrior) {
        allyInFront.restoreHp(this.healingPower)
    }


    override fun toString(): String {
        return """Healer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Healing power = ${this.getHealingPower}"""
    }
}