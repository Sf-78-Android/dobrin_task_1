package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.settings.Constants
import game.settings.Params

class Vampire : WarriorDecorator() {
    private var initialHealth = Params.Vampire.HEALTH
    private var health = initialHealth
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Vampire.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }
    private var vampirism: Int = Params.Vampire.VAMPIRISM
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    val getVampirism: Int
        get() = vampirism


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore - opponent.getHealth
        val healPoints = (damageDealt * vampirism) / Constants.ONE_HUNDRED
        restoreHp(healPoints)
    }

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
        vampirism += weapon.getVampirism()

    }


    override fun toString(): String {
        return """Vampire
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Vampirism = ${this.getVampirism}
     """
    }
}