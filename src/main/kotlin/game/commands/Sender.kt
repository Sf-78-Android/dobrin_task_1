package game.commands

import game.interfaces.BaseWarrior


class Sender {
    private lateinit var commandList: MutableList<Command>


    fun setCommand(commands: MutableList<Command>) {
        commandList = commands
    }


    fun commandHeal(attacker : BaseWarrior) {
        commandList.stream().filter { it is HealCommand }.findFirst().get().execute(attacker)
    }

    fun commandMove() {
        commandList.stream().filter { it is MoveUnitsCommand }.findFirst().get().execute()
    }

    fun clearDead() {
        commandList.stream().filter { it is ClearDeadCommand }.findFirst().get().execute()
    }
}