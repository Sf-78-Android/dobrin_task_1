package game.characters

import game.enums.FightType
import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
import game.testInteractions.Battle
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class HealerTest {

    @Test
    @DisplayName("1. Fight")
    fun `Check if healer actually heals`() {
        // given
        val Army1 = TestArmy()
        val Army2 = TestArmy()
        Army1.addUnits(1, TestWarriorType.Warrior)
        Army1.addUnits(1, TestWarriorType.Healer)
        Army2.addUnits(1, TestWarriorType.Warrior)
        // when

        val res = Battle.fight(Army2,Army1)
        // then
        assertEquals(false,res)
    }

    @Test
    @DisplayName("1. Fight")
    fun `Check if healer actually heals kk`() {
        // given
        val warrior1 = Healer()
        val warrior2 = Warrior()
        val warrior3 = Warrior()
        // when

       warrior3.hit(warrior2, FightType.Classic)
        warrior1.heal(warrior2,FightType.Classic)
       val res = warrior2.getHealth
        // then
        assertEquals(47,res)
    }
}