package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.settings.Params

class Lancer : WarriorDecorator() {
    private val initialHealth = Params.Lancer.HEALTH
    private var health: Int = Params.Lancer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Lancer.ATTACK
    private val pierce = Params.Lancer.PIERCING_POWER
    private val defence: Int = Params.Lancer.DEFENCE
    private val vampirism: Int = Params.Lancer.VAMPIRISM
    private val healingPower: Int = Params.Lancer.HEALING_POWER

    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    override val getDefence: Int
        get() = defence
    override val getVampirism: Int
        get() = vampirism
    override val getHealingPower: Int
        get() = healingPower

    override val isAlive: Boolean
        get() = health > 0


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore - opponent.getHealth
        val healPoints = (damageDealt * vampirism) / 100
        restoreHp(healPoints)
        if (fightType == FightType.Classic) {
            val damageToNext: Int = (damageDealt * pierce) / 100
            val hpFromNext = (damageToNext * vampirism) / 100
            opponent.warriorBehind?.let { receiveDamage(damageToNext) }
            restoreHp(hpFromNext)
        }
    }

    override fun receiveDamage(damage: Int) {
        health -= (damage - defence).coerceAtLeast(0)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun toString(): String {
        return """Lancer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }
}


