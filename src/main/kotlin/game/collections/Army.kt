package game.collections

import game.enums.WarriorType
import game.factory.getWarrior
import game.interfaces.BaseWarrior

class Army {
    private val troops = mutableListOf<BaseWarrior>()
    private var currentWarrior : BaseWarrior? = null
    fun addUnits(quantity: Int, type: WarriorType ) {
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


    fun killedWarrior() {
        troops.removeFirst()
    }
    fun killedWarrior(position : Int) {
        troops.removeAt(position)
    }

    val hasTroopsLeft: Boolean
        get() = troops.size > 0

    val size : Int
        get() = troops.size

    fun getWarriorAtPosition(position : Int)  : BaseWarrior {
        return troops[position]
    }

}
