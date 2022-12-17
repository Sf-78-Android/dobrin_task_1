package game.testCollections

import game.interfaces.BaseWarrior

class TestArmy{
    private val troops = mutableListOf<BaseWarrior>()
    private var currentWarrior : BaseWarrior? = null
    fun addUnits(quantity: Int, type : String ) {
        repeat(quantity) {
            val warrior = game.testFactory.getWarrior(type)
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

    val hasTroopsLeft: Boolean
        get() = troops.size > 0


}
