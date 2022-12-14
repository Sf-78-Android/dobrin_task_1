package game.testClass

import game.characters.Warrior
import game.interfaces.BaseWarrior
import game.settings.Params

class Rookie : BaseWarrior {
    override val attack: Int = 1
    override fun hit(opponent: BaseWarrior) {
        TODO("Not yet implemented")
    }

    override fun receiveDamage(damage: Int) {
        TODO("Not yet implemented")
    }

    override val isAlive: Boolean
        get() = TODO("Not yet implemented")
    override var warriorBehind: BaseWarrior?
        get() = TODO("Not yet implemented")
        set(value) {}
    override val getHealth: Int
        get() = TODO("Not yet implemented")
}