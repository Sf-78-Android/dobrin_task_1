package game.commands

class AddOrders(sender: Sender, receivers: MutableList<Receiver>) {
    init {
        val healCommand = HealCommand(receivers)
        val moveTroopsCommand = MoveUnitsCommand(receivers)
        val clearDead = ClearDeadCommand(receivers)

        sender.setCommand(mutableListOf(healCommand,moveTroopsCommand,clearDead))

    }


}