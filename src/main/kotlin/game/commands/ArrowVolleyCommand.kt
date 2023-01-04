package game.commands

import game.interfaces.BaseWarrior

class ArrowVolleyCommand(receivers: MutableList<Receiver>) : Command(receivers){
    override fun execute() {
        for (receiver in receivers){
            receiver.sendArrows()
        }
    }

    override fun execute(attacker: BaseWarrior) {
        for (receiver in receivers){
            receiver.sendArrows()
        }
    }
}