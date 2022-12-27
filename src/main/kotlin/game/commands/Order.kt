package game.commands

import game.interfaces.BaseWarrior

class Order(sender: Sender, receiver: MutableList<BaseWarrior>) {

    init {
        // setting the Invoker command
        val concreteCommand = ConcreteCommand(receiver)
        sender.setCommand(concreteCommand)
    }
}