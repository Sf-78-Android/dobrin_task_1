package game.commands

class Sender {
    private lateinit var aCommand: Command

    fun setCommand(command: Command) {
        aCommand = command
    }

    fun performAction() {
        aCommand.execute()
    }
}