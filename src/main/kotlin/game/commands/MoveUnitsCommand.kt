package game.commands

class MoveUnitsCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers) {
                receiver.moveUnits()
        }
    }
}