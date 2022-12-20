package game.characters


import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.CanHeal
import game.settings.Params

class Warrior : WarriorDecorator() {
    private val initialHealth = Params.Warrior.HEALTH
    private val attack: Int = Params.Warrior.ATTACK
    private var health: Int = Params.Warrior.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val defence: Int = Params.Warrior.DEFENCE
    private val vampirism: Int = Params.Warrior.VAMPIRISM
    private val healingPower: Int = Params.Warrior.HEALING_POWER

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
        return """Warrior
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Defence = ${this.getDefence}
      Vampirism = ${this.getVampirism}
      Healing power = ${this.getHealingPower}"""
    }

}

