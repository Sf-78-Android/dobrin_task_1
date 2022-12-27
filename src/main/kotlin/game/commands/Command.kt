package game.commands

import game.interfaces.BaseWarrior


abstract class Command(val receiver: MutableList<BaseWarrior>) {
   abstract fun execute()
}