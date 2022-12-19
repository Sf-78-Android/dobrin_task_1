package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Lancer (val warrior : BaseWarrior): WarriorDecorator(warrior) {
    private val initialHealth = Params.Lancer.HEALTH
    private var health : Int = Params.Lancer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack: Int = Params.Lancer.ATTACK
    private val pierce = Params.Lancer.PIERCING_POWER


    override val isAlive: Boolean
        get() = health>0


    override val getHealth: Int
        get() = health

    override fun hit(opponent: BaseWarrior) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore-opponent.getHealth
        val damageToNext : Int = (damageDealt*pierce)/100
        opponent.warriorBehind?.let { receiveDamage( damageToNext) }

    }

    override fun receiveDamage(damage: Int) {
        health-=damage
    }

    override fun restoreHp(amountHp: Int) {
        health+=amountHp
    }

    override var warriorBehind: BaseWarrior? = null

}


