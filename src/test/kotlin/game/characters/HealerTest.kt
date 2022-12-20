package game.characters

import game.collections.Army
import game.enums.FightType
import game.enums.WarriorType
import game.factory.getWarrior
import game.interactions.Battle
import game.settings.Params
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class HealerTest {

    @Test
    @DisplayName("1. Fight")
    fun `Check if healer actually heals`() {
        // given
        val Army1 = Army()
        val Army2 = Army()
        Army1.addUnits(1, WarriorType.Warrior)
        Army1.addUnits(1, WarriorType.Healer)
        Army2.addUnits(1, WarriorType.Warrior)
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