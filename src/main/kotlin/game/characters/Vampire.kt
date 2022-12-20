package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Vampire : WarriorDecorator() {
    private val initialHealth = Params.Vampire.HEALTH
    private var health = initialHealth
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Vampire.ATTACK
    private val defence: Int = Params.Vampire.DEFENCE
    private val vampirism: Int = Params.Vampire.VAMPIRISM
    private val healingPower: Int = Params.Vampire.DEFENCE

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
        return """Vampire
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }
}