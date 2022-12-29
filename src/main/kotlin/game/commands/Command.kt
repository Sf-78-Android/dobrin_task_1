package game.commands


abstract class Command(val receivers: MutableList<Receiver>) {
   abstract fun execute()
}