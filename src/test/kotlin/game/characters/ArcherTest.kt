package game.characters

import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import game.testCollections.TestArmy
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ArcherTest {

    @Test
    @DisplayName("1. Battle")
    fun `Army of warriors losses against Army of defenders`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20,  WarriorType.Defender)
        firstArmy.addUnits(30,  WarriorType.Defender)
        firstArmy.addUnits(1,  WarriorType.Lancer)
        firstArmy.addUnits(1,  WarriorType.Warlord)


        val secondArmy = Army()
        secondArmy.addUnits(30,  WarriorType.Archer)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        val res2 = firstArmy.containsWarlord()
        assertEquals(false, res2)
        assertEquals(true, res)
    }
}