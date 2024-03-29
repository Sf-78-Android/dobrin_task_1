package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon
import game.settings.Constants
import game.settings.Params

class Defender : WarriorDecorator() {
    private var initialHealth = Params.Defender.HEALTH
    private var health: Int = Params.Defender.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Defender.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }
    private var defence: Int = Params.Defender.DEFENCE
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    val getDefence: Int
        get() = defence


    override fun receiveDamage(damage: Int) {
        health -= (damage - defence).coerceAtLeast(Constants.ZERO)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth()
        health = initialHealth
        attack += weapon.getAttack()
        defence += weapon.getDefence()
        this.equippedWeapon(weapon)
    }

    override fun toString(): String {
        return """Defender
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
     """
    }
}