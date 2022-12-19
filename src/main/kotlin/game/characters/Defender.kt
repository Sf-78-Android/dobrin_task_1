package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Defender (val warrior: Warrior) : WarriorDecorator(warrior) {
    private val initialHealth = Params.Defender.HEALTH
    private var health : Int = Params.Defender.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
     private val attack: Int = Params.Defender.ATTACK
     private val defence: Int
     get()= Params.Defender.DEFENCE

    override fun hit(opponent: BaseWarrior) {
        opponent.receiveDamage(attack)
    }

    override fun receiveDamage(damage: Int) {
        health-= (damage-defence).coerceAtLeast(0)
    }


    override var warriorBehind: BaseWarrior? = null

    override val isAlive: Boolean
        get() = health>0

    override fun restoreHp(amountHp: Int) {
       health+=amountHp
    }


    override val getHealth: Int
        get() = health


}