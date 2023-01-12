package game.commands

import game.interfaces.BaseWarrior


abstract class Command(val receivers: MutableList<Receiver>) {
    open fun execute() {
    }
    open fun execute(attacker: BaseWarrior) {
    }
    open fun execute(attacker: BaseWarrior,defender: BaseWarrior) {
    }
}