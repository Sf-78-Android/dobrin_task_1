package game.commands

class MoveUnitsCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers) {
            if (!receiver.sorted) {
                receiver.moveUnits()
            }
        }
    }
}