package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.CanDrainHp
import game.settings.Params

class Vampire (val warrior: BaseWarrior) : WarriorDecorator(warrior), CanDrainHp {
    private val initialHealth = Params.Vampire.HEALTH
    private var health = initialHealth
    private set(value) {
        field = value.coerceAtMost(initialHealth)
    }
    private val attack: Int = Params.Vampire.ATTACK
    private val vampirism: Int = Params.Vampire.VAMPIRISM


    override fun drainHp(hpDrained: Int) {
        health+=hpDrained
    }

    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore-opponent.getHealth
        val healPoints = (damageDealt*vampirism) / 100
        drainHp(healPoints)
    }

    override fun receiveDamage(damage: Int) {
        health-=damage
    }

    override fun restoreHp(amountHp: Int) {
        health+=amountHp
    }

    override var warriorBehind: BaseWarrior? = null

    override val isAlive: Boolean
        get() = health > 0


    override val getHealth: Int
        get() = health


}