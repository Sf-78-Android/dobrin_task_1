package game.decorators

import game.interfaces.BaseWarrior

abstract class LancerDecorator (warrior: BaseWarrior) : WarriorDecorator(warrior) {

    abstract fun pierce (opponent: BaseWarrior, damage : Int)
}