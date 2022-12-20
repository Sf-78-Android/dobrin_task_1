package game.characters

import game.decorators.WarriorDecorator
import game.settings.Params


class Knight : WarriorDecorator() {
    private val initialHealth = Params.Knight.HEALTH
    private var health: Int = Params.Knight.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Knight.ATTACK
    private val defence: Int = Params.Knight.DEFENCE
    private val vampirism: Int = Params.Knight.VAMPIRISM
    private val healingPower: Int = Params.Knight.HEALING_POWER

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


    override fun receiveDamage(damage: Int) {
        health -= (damage - defence).coerceAtLeast(0)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun toString(): String {
        return """Knight
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }
}