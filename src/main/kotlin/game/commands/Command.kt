package game.commands

import game.interfaces.BaseWarrior


abstract class Command(val receivers: MutableList<Receiver>) {
    abstract fun execute()
    open fun execute(attacker: BaseWarrior) {
    }
}