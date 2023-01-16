package game.collections

import game.characters.Warlord
import game.characters.Warrior
import game.commands.Receiver
import game.enums.WarriorType
import game.factory.getWarrior
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.settings.Constants

class Army : Receiver() {
    private var name : String? = null
    private var currentWarrior: BaseWarrior? = null


    fun addUnits(quantity: Int, type: WarriorType) {

        repeat(quantity) {
            val warrior = getWarrior(type)

            if (warrior is Warlord && !this.containsWarlord()) {
                warrior.warriorIfFront = currentWarrior
                units.add(warrior)
            } else if(warrior !is Warlord) {
                units.add(warrior)
            }
            if (units.size > Constants.ONE) {
                this.updatePositions()
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
        get() = units.size > Constants.ZERO

    val size: Int
        get() = units.size

    fun getWarriorAtPosition(position: Int): BaseWarrior {
        return units[position]
    }

    fun equipWarriorAtPosition(position: Int, weapon: BaseWeapon) {
        units[position].equipWeapon(weapon)
    }

    fun setArmyName(name : String) {
        this.name =name
    }

    override fun toString(): String {
        return "Army(name=$name)"
    }


}


