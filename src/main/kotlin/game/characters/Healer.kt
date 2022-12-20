package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Healer : WarriorDecorator() {
    private val initialHealth = Params.Defender.HEALTH
    private var health: Int = Params.Healer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Healer.ATTACK
    private val healingPower: Int
        get() = Params.Healer.HEALING_POWER
    private val defence: Int
        get() = Params.Healer.DEFENCE
    private val vampirism: Int = Params.Healer.VAMPIRISM

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


    override fun receiveDamage(damage: Int) {
        health -= (damage - defence).coerceAtLeast(0)
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun toString(): String {
        return """Healer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }
}