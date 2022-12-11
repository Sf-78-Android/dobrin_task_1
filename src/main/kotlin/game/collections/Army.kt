package game.collections

import game.characters.Warrior

class Army {
    private val troops = mutableListOf<Warrior>()
    private var currentWarrior : Warrior? = null
    fun addUnits(quantity: Int, factory: () -> Warrior) {
        repeat(quantity) {
            val warrior= factory()
            if (troops.size == 0) {
                currentWarrior = warrior
                troops.add(warrior)
            } else {
                currentWarrior?.warriorBehind=warrior.also { currentWarrior=warrior }
                troops.add(warrior)
            }
        }
    }

    fun nextWarrior(): Warrior {
        return troops.first()
    }

    private fun piercedWarrior(): Warrior? {
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
