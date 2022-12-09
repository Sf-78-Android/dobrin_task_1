package collections

import characters.Warrior

class Army {
    private val troops = mutableListOf<Warrior>()
    fun addUnits(quantity: Int, factory: () -> Warrior) {
        repeat(quantity) {
            val warrior1 = factory()
            troops.add(warrior1)
        }
    }

    fun nextWarrior(): Warrior {
        return troops.first()
    }

    fun piercedWarrior(): Warrior? {
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
