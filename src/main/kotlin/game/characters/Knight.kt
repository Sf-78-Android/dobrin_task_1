package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params


class Knight(warrior: BaseWarrior) : WarriorDecorator(warrior) {
    private val initialHealth = Params.Knight.HEALTH
    private var health: Int = Params.Knight.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Knight.ATTACK

    override fun hit(opponent: BaseWarrior) {
        opponent.receiveDamage(attack)
    }

    override fun receiveDamage(damage: Int) {
        health -= damage
    }


    override var warriorBehind: BaseWarrior? = null

    override val isAlive: Boolean
        get() = health > 0


    override val getHealth: Int
        get() = health

}