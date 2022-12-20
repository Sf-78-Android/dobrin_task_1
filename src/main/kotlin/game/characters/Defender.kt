package game.characters

import game.decorators.WarriorDecorator
import game.settings.Params
import game.weapons.Weapon

class Defender : WarriorDecorator() {
    private var initialHealth = Params.Defender.HEALTH
    private var health: Int = Params.Defender.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private var attack: Int = Params.Defender.ATTACK
    private var defence: Int = Params.Defender.DEFENCE


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    private val getDefence: Int
        get() = defence



    override fun receiveDamage(damage: Int) {
        health -= (damage-defence).coerceAtLeast(0)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: Weapon) {
        weapons.addWeapon(weapon)
        initialHealth+= weapon.getHealth
        attack+=weapon.getAttack
        defence+=weapon.getDefence

    }

    override fun toString(): String {
        return """Defender
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
     """
    }
}