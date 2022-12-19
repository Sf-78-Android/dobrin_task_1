package game.characters

import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Defender (val warrior: Warrior,private var health : Int = Params.Defender.HEALTH) : WarriorDecorator(warrior) {
    private val attack: Int = Params.Defender.ATTACK
    private val defence: Int
        get()= Params.Defender.DEFENCE

    override fun hit(opponent: BaseWarrior) {
        opponent.receiveDamage(attack)
    }

    override fun receiveDamage(damage: Int) {
        health-= (damage-defence).coerceAtLeast(0)
    }

    override val isAlive: Boolean
        get() = health>0
    override val getHealth: Int
        get() = health


}