package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.settings.Constants
import game.settings.Params
import log.constants.MsgTemplate.lancerHitMsg

class Lancer : WarriorDecorator() {
    private var initialHealth = Params.Lancer.HEALTH
    private var health: Int = Params.Lancer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Lancer.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }
    private val pierce = Params.Lancer.PIERCING_POWER


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth()
        health = initialHealth
        attack += weapon.getAttack()
        this.equippedWeapon(weapon)

    }


    override val isAlive: Boolean
        get() = health > Constants.ZERO


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(getAttack)
        val damageDealt = healthBefore - opponent.getHealth
        if (fightType == FightType.Classic) {
            val damageToNext: Int = (damageDealt * pierce) / Constants.ONE_HUNDRED
            if (opponent.warriorBehind?.isAlive == false) {
                opponent.warriorBehind = opponent.warriorBehind?.warriorBehind
            }
            opponent.warriorBehind?.receiveDamage(damageToNext)
            Battle.getLog().logMessage(String.format(lancerHitMsg, this.javaClass.simpleName,opponent.javaClass.simpleName,damageDealt,opponent.warriorBehind?.javaClass?.simpleName,damageToNext))
        }
    }

    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }


    override fun toString(): String {
        return """Lancer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      """
    }
}


