package game.testClass

import game.characters.Warrior
import game.decorators.WarriorDecorator
import game.interfaces.BaseWarrior
import game.settings.Params

class Rookie (private val warrior: Warrior, private var health : Int = Params.TestRookie.HEALTH) : WarriorDecorator(warrior) {
     private val attack: Int = Params.TestRookie.ATTACK
    override fun hit(opponent: BaseWarrior) {
        opponent.receiveDamage(attack)
    }

    override fun receiveDamage(damage: Int) {
       health-=damage
    }

    override val isAlive: Boolean
        get() =health>0
    override var warriorBehind: BaseWarrior? = null

    override val getHealth: Int
        get() = health
}