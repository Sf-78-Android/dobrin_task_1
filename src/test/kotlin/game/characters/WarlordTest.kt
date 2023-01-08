package game.characters

import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WarlordTest {

    @Test
    @DisplayName("1. Warlord moves units")
    fun `Check if Warlord is present that army is rearranged`() {
        val myArmy = Army()
        myArmy.addUnits(1, WarriorType.Warlord)
        myArmy.addUnits(2, WarriorType.Warrior)
        myArmy.addUnits(2, WarriorType.Lancer)
        myArmy.addUnits(2, WarriorType.Healer)

        val enemyArmy = Army()
        enemyArmy.addUnits(3, WarriorType.Warlord)
        enemyArmy.addUnits(1, WarriorType.Vampire)
        enemyArmy.addUnits(2, WarriorType.Healer)
        enemyArmy.addUnits(2, WarriorType.Knight)

        myArmy.moveUnits()
        enemyArmy.moveUnits()

// you can provide any other interface for testing the order
        assert(myArmy.getWarriorAtPosition(0) is Lancer)
        assert(myArmy.getWarriorAtPosition(1) is Healer)
// negative index means from the last position, so -1 == last
        assert(myArmy.getWarriorAtPosition(myArmy.size-1) is Warlord)

        assert(enemyArmy.getWarriorAtPosition(0)is Vampire)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-1) is Warlord)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-2) is Knight)

//6, not 8, because only 1 Warlord per army could be
        assert(enemyArmy.size == 6)

        assert(Battle.fight(myArmy, enemyArmy) == true)
    }

    @Test
    @DisplayName("1. Warlord moves units with archers")
    fun `Check if Warlord is present that army is rearranged with archers`() {
        val myArmy = Army()
        myArmy.addUnits(1, WarriorType.Warlord)
        myArmy.addUnits(2, WarriorType.Warrior)
        myArmy.addUnits(2, WarriorType.Archer)
        myArmy.addUnits(2, WarriorType.Lancer)
        myArmy.addUnits(2, WarriorType.Healer)

        val enemyArmy = Army()
        enemyArmy.addUnits(3, WarriorType.Warlord)
        enemyArmy.addUnits(1, WarriorType.Vampire)
        enemyArmy.addUnits(1, WarriorType.Archer)
        enemyArmy.addUnits(2, WarriorType.Healer)
        enemyArmy.addUnits(2, WarriorType.Knight)

        myArmy.moveUnits()
        enemyArmy.moveUnits()

// you can provide any other interface for testing the order
        assert(myArmy.getWarriorAtPosition(0) is Lancer)
        assert(myArmy.getWarriorAtPosition(myArmy.size-2) is Archer)
        assert(myArmy.getWarriorAtPosition(1) is Healer)
// negative index means from the last position, so -1 == last
        assert(myArmy.getWarriorAtPosition(myArmy.size-1) is Warlord)

        assert(enemyArmy.getWarriorAtPosition(0)is Vampire)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-1) is Warlord)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-2) is Archer)


//6, not 8, because only 1 Warlord per army could be
        assert(enemyArmy.size == 7)

        assert(Battle.fight(myArmy, enemyArmy) == true)
    }



    @Test
    @DisplayName("1. Doesn't moves units")
    fun `Check if no Warlord is  present that army is not rearranged`() {
        val myArmy = Army()
        myArmy.addUnits(1, WarriorType.Warrior)
        myArmy.addUnits(2, WarriorType.Warrior)
        myArmy.addUnits(2, WarriorType.Lancer)
        myArmy.addUnits(2, WarriorType.Healer)

        val enemyArmy = Army()
        enemyArmy.addUnits(3, WarriorType.Warlord)
        enemyArmy.addUnits(1, WarriorType.Vampire)
        enemyArmy.addUnits(2, WarriorType.Healer)
        enemyArmy.addUnits(2, WarriorType.Knight)

        myArmy.moveUnits()
        enemyArmy.moveUnits()

// you can provide any other interface for testing the order
        assert(myArmy.getWarriorAtPosition(0) !is Lancer)
        assert(myArmy.getWarriorAtPosition(1) !is Healer)
// negative index means from the last position, so -1 == last
        assert(myArmy.getWarriorAtPosition(myArmy.size-1) !is Warlord)

        assert(enemyArmy.getWarriorAtPosition(0)is Vampire)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-1) is Warlord)
        assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-2) is Knight)

//6, not 8, because only 1 Warlord per army could be
        assert(enemyArmy.size == 6)

        assert(Battle.fight(myArmy, enemyArmy) == false)
    }

}