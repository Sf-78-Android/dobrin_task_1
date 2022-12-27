package game.testCollections

import game.enums.WarriorType
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.testFactory.getWarrior

class TestArmy {
    private val troops = mutableListOf<BaseWarrior>()
    private var currentWarrior : BaseWarrior? = null
    fun addUnits(quantity: Int, type: WarriorType) {
        repeat(quantity) {
            var warrior = getWarrior(type)
            if (troops.isEmpty()) {
                currentWarrior = warrior
                troops.add(warrior)
            } else {
                currentWarrior?.warriorBehind=warrior.also { currentWarrior=warrior }
                troops.add(warrior)
                warrior.warriorIfFront = troops[troops.indexOf(warrior)-1]
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

    fun equipWarriorAtPosition(i: Int, weapon: BaseWeapon) {
        troops[i].equipWeapon(weapon)
    }

}
