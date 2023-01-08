package game.characters

import game.collections.Army
import game.enums.FightType
import game.enums.WarriorType
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.testCollections.TestArmy
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class HealerTest {

    @Test
    @DisplayName("1. Fight")
    fun `Check if healer actually heals`() {
        // given
        val Army1 = TestArmy()
        val Army2 = TestArmy()
        Army1.addUnits(1, WarriorType.Warrior)
        Army1.addUnits(1, WarriorType.Healer)
        Army1.addUnits(1,WarriorType.Warrior)
        // when

        val res = TestBattle.fight(Army2, Army1)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("1. Fight")
    fun `Check if all healers actually heal`() {
        // given
        val Army1 = Army()
        val Army2 = Army()
        val tom = Lancer()


        Army1.addUnits(1, WarriorType.Lancer)
        Army1.addUnits(1, WarriorType.Healer)
        Army1.addUnits(1, WarriorType.Healer)
        Army1.addUnits(1, WarriorType.Lancer)
        val warrior1 = Army1.getWarriorAtPosition(3)
        tom.hit(warrior1, fightType = FightType.Classic)
        Army1.addUnits(1, WarriorType.Healer)
        Army2.addUnits(1, WarriorType.Lancer)
        // when

        val res = Battle.fight(Army2, Army1)
        val res2 = warrior1.getHealth
        assertEquals(false, res)
        assertEquals(60, res2)
    }

    @Test
    @DisplayName("1. Fight")
    fun `Check if healer actually heals 2`() {
        // given
        val warrior1 = Healer()
        val warrior2 = Warrior()
        val warrior3 = Warrior()
        // when

        warrior3.hit(warrior2, FightType.Classic)
        warrior1.heal(warrior2)
        val res = warrior2.getHealth
        // then
        assertEquals(47, res)
    }


    @ParameterizedTest
    @MethodSource("fight")
    fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior, expected: Boolean) {
        val res1 = Battle.fight(warrior1, warrior2)
        val res2 = warrior1.isAlive
        val res3 = warrior2.isAlive

        assertAll(
            { assertEquals(expected, res1, "Fight result is wrong") },
            { assertEquals(expected, res2, "First warrior isAlive is wrong") },
            { assertEquals(!expected, res3, "Second warrior isAlive is wrong") }
        )
    }

    companion object {
        @JvmStatic
        fun fight(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Warrior(), Warrior(), true),
                Arguments.of(Warrior(), Knight(), false),
                Arguments.of(Knight(), Warrior(), true),
                Arguments.of(Knight(), Knight(), true)
            )
        }
    }
}