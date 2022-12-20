package game.characters

import game.decorators.WarriorDecorator
import game.settings.Params

class Defender : WarriorDecorator() {
    private val initialHealth = Params.Defender.HEALTH
    private var health: Int = Params.Defender.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Defender.ATTACK
    private val defence: Int = Params.Defender.DEFENCE
    private val vampirism: Int = Params.Defender.VAMPIRISM
    private val healingPower: Int = Params.Defender.HEALING_POWER

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
        return """Defender
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }
}