package game.characters

import game.collections.Army
import game.enums.WarriorType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertIs
import kotlin.test.assertNull

internal class ArmyTest {
    @Test
    @DisplayName("Check addUnits method without Warlord")
    fun `Does method set warriorInFront and warriorBehind`() {
        val army1 = Army()
        army1.addUnits(1,  WarriorType.Warlord)

        val warrior = army1.getWarriorAtPosition(0)

        assertNull(warrior.warriorIfFront)
        assertNull(warrior.warriorBehind)

        val army2 = Army()
        army2.addUnits(1,  WarriorType.Lancer)
        army2.addUnits(1,  WarriorType.Vampire)
        army2.addUnits(1,  WarriorType.Healer)


        val res = army2.getWarriorAtPosition(0).warriorIfFront
        val res2 = army2.getWarriorAtPosition(1).warriorIfFront
        val res3 = army2.getWarriorAtPosition(1).warriorBehind
        assertNull(res)
        assertIs<Lancer>(res2)
        assertIs<Healer>(res3)
    }
    @Test
    @DisplayName("Check addUnits method 2")
    fun `Does set correct warriors in front and in the back`() {
        val army1 = Army()
        army1.addUnits(1,  WarriorType.Warlord)
        army1.addUnits(1,  WarriorType.Lancer)
        army1.addUnits(1,  WarriorType.Archer)
        army1.addUnits(1,  WarriorType.Healer)
        army1.addUnits(1,  WarriorType.Healer)

        val res4 = army1.getWarriorAtPosition(0).warriorIfFront
        val res5 = army1.getWarriorAtPosition(0).warriorBehind
        val res6 = army1.getWarriorAtPosition(1).warriorIfFront
        val res7 = army1.getWarriorAtPosition(1).warriorBehind
        val res8 = army1.getWarriorAtPosition(2).warriorIfFront
        val res9 = army1.getWarriorAtPosition(2).warriorBehind
        assertNull(res4)
        assertIs<Lancer>(res5)
        assertIs<Warlord>(res6)
        assertIs<Archer>(res7)
        assertIs<Lancer>(res8)
        assertIs<Healer>(res9)



        val army2 = Army()
        army2.addUnits(1,  WarriorType.Lancer)
        army2.addUnits(1,  WarriorType.Vampire)
        army2.addUnits(1,  WarriorType.Healer)


        val res = army2.getWarriorAtPosition(0).warriorIfFront
        val res2 = army2.getWarriorAtPosition(1).warriorIfFront
        val res3 = army2.getWarriorAtPosition(1).warriorBehind
        assertNull(res)
        assertIs<Lancer>(res2)
        assertIs<Healer>(res3)
    }
}