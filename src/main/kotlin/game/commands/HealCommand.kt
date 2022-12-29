package game.commands

class HealCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute() {
        for (receiver in receivers) {
            receiver.heal()
        }
    }
}

