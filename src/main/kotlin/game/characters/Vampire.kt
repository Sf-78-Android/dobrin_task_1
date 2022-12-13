package game.characters

import game.decorators.VampireDecorator
import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior

import game.settings.Params

class Vampire (val warrior: BaseWarrior) : VampireDecorator(warrior) {
    private val initialHealth = Params.Vampire.HEALTH
    private var health = initialHealth
    private set(value) {
        field = value.coerceAtMost(initialHealth)
    }
    private val attack: Int = Params.Vampire.ATTACK
    val vampirism: Int = Params.Vampire.VAMPIRISM


    override fun drainHp(hpDrained: Int) {
        health+=hpDrained
    }

    override fun hit(opponent: BaseWarrior) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore-opponent.getHealth
        val healPoints = (damageDealt*vampirism) / 100
        drainHp(healPoints)
    }

    override fun receiveDamage(damage: Int) {
       health-=damage
    }

    override val isAlive: Boolean
        get() = health > 0
    override val getHealth: Int
        get() = health


}