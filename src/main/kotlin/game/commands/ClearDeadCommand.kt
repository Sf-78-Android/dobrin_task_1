package game.commands

class ClearDeadCommand (receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers){
            receiver.clearDeadBodies()
        }
    }
}