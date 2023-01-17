package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon
import game.settings.Constants
import game.settings.Params


class Knight : WarriorDecorator() {
    private var initialHealth = Params.Knight.HEALTH
    private var health: Int = Params.Knight.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Knight.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack


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
        attack += weapon.getAttack()
        this.equippedWeapon(weapon)

    }

    override fun toString(): String {
        return """Knight
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
     """
    }
}