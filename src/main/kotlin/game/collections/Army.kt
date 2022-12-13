package game.collections

import game.factory.getWarrior
import game.interfaces.BaseWarrior
import java.lang.management.ManagementFactory

class Army {
    private val troops = mutableListOf<BaseWarrior>()
    private var currentWarrior : BaseWarrior? = null
    fun addUnits(quantity: Int, type : String ) {
        repeat(quantity) {
            val warrior = getWarrior(type)
            if (troops.size == 0) {
                currentWarrior = warrior
                troops.add(warrior)
            } else {
                currentWarrior?.warriorBehind=warrior.also { currentWarrior=warrior }
                troops.add(warrior)
            }
        }
    }

    fun nextWarrior(): BaseWarrior {
        return troops.first()
    }

    //TODO remove this two methods
    private fun piercedWarrior(): BaseWarrior? {
        if (troops.size >= 2) {
            return troops[1]
        }
        return null
    }

    fun killedPiercedWarrior() {
        if (troops.size >= 2) {
            troops.removeAt(1)
        }
    }

    fun killedWarrior() {
        troops.removeFirst()
    }

    val hasTroopsLeft: Boolean
        get() = troops.size > 0


}
