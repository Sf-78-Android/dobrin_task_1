package game.commands

import game.interfaces.BaseWarrior


class ArrowVolleyCommand(receivers: MutableList<Receiver>) : Command(receivers) {
    override fun execute(attacker: BaseWarrior, defender: BaseWarrior) {
        val enemyArmy = receivers.stream().filter { it.contains(defender) }.findFirst().get()
        for (receiver in receivers) {
            if (receiver.contains(attacker)) {
                receiver.sendArrows(enemyArmy)
            }
        }
    }
}