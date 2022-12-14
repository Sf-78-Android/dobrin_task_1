package game.decorators

import game.interfaces.BaseWarrior


abstract class WarriorDecorator(private val warrior: BaseWarrior) : BaseWarrior {

    override fun hit(opponent: BaseWarrior) {
        warrior.hit(opponent)
    }

    override fun receiveDamage(damage: Int) {
        warrior.receiveDamage(damage)
    }


    abstract override val isAlive: Boolean

    override var warriorBehind: BaseWarrior? = null


}