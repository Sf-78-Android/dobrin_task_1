package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.settings.Params
import game.weapons.Weapon

class Lancer : WarriorDecorator() {
    private var initialHealth = Params.Lancer.HEALTH
    private var health: Int = Params.Lancer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private var attack: Int = Params.Lancer.ATTACK
    private val pierce = Params.Lancer.PIERCING_POWER


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack


    override val isAlive: Boolean
        get() = health > 0


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore - opponent.getHealth
        if (fightType == FightType.Classic) {
            val damageToNext: Int = (damageDealt * pierce) / 100
            opponent.warriorBehind?.receiveDamage(damageToNext)

        }
    }

    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: Weapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth
        attack += weapon.getAttack
    }

    override fun toString(): String {
        return """Lancer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      """
    }
}


