package game.decorators

import game.interfaces.BaseWarrior

abstract class VampireDecorator(warrior: BaseWarrior): WarriorDecorator(warrior) {

  abstract fun drainHp(hpDrained : Int)
}