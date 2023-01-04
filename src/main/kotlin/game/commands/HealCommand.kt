package game.commands

import game.interfaces.BaseWarrior

class HealCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers) {
            receiver.heal()
        }
    }

    override fun execute(attacker: BaseWarrior) {
        for (receiver in receivers) {
            if (receiver.contains(attacker)) {
                receiver.heal()
            }
        }

    }
}

