package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon
import game.settings.Constants
import game.settings.Params

class Warlord : WarriorDecorator() {
    private var initialHealth = Params.Warlord.HEALTH
    private var health: Int = Params.Warlord.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Warlord.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }
    private var defence: Int = Params.Warlord.DEFENCE
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }

    override fun receiveDamage(damage: Int) {
        health -= (damage - defence).coerceAtLeast(Constants.ZERO)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override val getHealth: Int
        get() = this.health
    override val getAttack: Int
        get() = this.attack

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth()
        health = initialHealth
        attack += weapon.getAttack()
        defence += weapon.getDefence()
        this.equippedWeapon(weapon)
    }
}