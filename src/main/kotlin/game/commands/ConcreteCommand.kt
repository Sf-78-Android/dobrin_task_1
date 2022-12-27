package game.commands

import game.characters.Healer
import game.interfaces.BaseWarrior

class ConcreteCommand(receiver: MutableList<BaseWarrior>) : Command(receiver) {
    override fun execute() {
        for (warrior in receiver) {
            if (warrior is Healer) {
                warrior.warriorIfFront?.let { warrior.heal(it) }
            }
        }
    }
}