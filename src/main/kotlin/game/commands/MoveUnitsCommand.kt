package game.commands

import game.interfaces.BaseWarrior

class MoveUnitsCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers) {
            if (receiver.containsWarlord()) {
                receiver.moveUnits()
            }
        }
    }


}