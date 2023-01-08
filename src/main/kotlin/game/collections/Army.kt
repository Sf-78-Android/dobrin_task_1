package game.collections

import game.characters.Warlord
import game.characters.Warrior
import game.commands.Receiver
import game.enums.WarriorType
import game.factory.getWarrior
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon

class Army : Receiver() {

    private var currentWarrior: BaseWarrior? = null


    fun addUnits(quantity: Int, type: WarriorType) {

        repeat(quantity) {
            val warrior = getWarrior(type)
            if (warrior is Warlord && !this.containsWarlord()) {

                warrior.warriorIfFront = currentWarrior
                units.add(warrior)

            } else {
                if (units.isEmpty() && warrior !is Warlord) {
                    currentWarrior = warrior
                    units.add(warrior)
                } else if (warrior !is Warlord) {
                    currentWarrior?.warriorBehind = warrior.also { currentWarrior = warrior }
                    units.add(warrior)
                    warrior.warriorIfFront = units[units.indexOf(warrior) - 1]
                }
            }
        }
    }

    fun nextWarrior(): BaseWarrior {
        return units.first()
    }


    fun killedWarrior(warrior: BaseWarrior) {
        units.remove(warrior)
    }

    val hasTroopsLeft: Boolean
        get() = units.size > 0

    val size: Int
        get() = units.size

    fun getWarriorAtPosition(position: Int): BaseWarrior {
        return units[position]
    }

    fun equipWarriorAtPosition(position: Int, weapon: BaseWeapon) {
        units[position].equipWeapon(weapon)
    }


}


