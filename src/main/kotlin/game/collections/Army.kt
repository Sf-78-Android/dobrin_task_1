package game.collections

import game.factory.getWarrior
import game.interfaces.BaseWarrior

class Army {
    private val troops = mutableListOf<BaseWarrior>()
    private  var currentWarrior : BaseWarrior? = null
    fun addUnits(quantity: Int, type : String ) {
        repeat(quantity) {
            val warrior = getWarrior(type)
            if (troops.isEmpty()) {
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

    val hasTroopsLeft: Boolean
        get() = troops.size > 0


}
