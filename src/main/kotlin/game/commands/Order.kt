package game.commands

class Client(sender : Sender) {
    private val receiver = Receiver()

    init {
        // setting the Invoker command
        val concreteCommand = ConcreteCommand(receiver)
        sender.setCommand(concreteCommand)
    }
}