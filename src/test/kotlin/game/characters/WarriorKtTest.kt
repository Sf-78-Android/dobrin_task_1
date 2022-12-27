package game.characters

import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import game.testCollections.TestArmy
import game.testFactory.getWarrior
import game.testInteractions.TestBattle
import game.weapons.MagicWand
import game.weapons.Sword
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals

internal class WarriorKtTest {
    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        // given
        val carl = Warrior()
        val jon = Knight()
        // when
        val res = TestBattle.fight(carl, jon)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Knight dies after more than one TestBattle`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        val jon = Knight()
        // when
        TestBattle.fight(jon, carl)
        TestBattle.fight(jon, tim)
        val res = jon.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Fight : First warrior wins against second warrior")
    fun `First warrior wins against second warrior`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        // when
        TestBattle.fight(tim, carl)
        val res = tim.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("4. Fight")
    fun `Knight wins after fighting another knight`() {
        // given
        val tim = Knight()
        val jon = Knight()
        // when
        TestBattle.fight(tim, jon)
        val res = tim.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Second warrior dies after loosing`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        // when
        TestBattle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("6. Fight")
    fun `Warrior cannot fight after he is dead`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        val jon = Knight()
        // when
        TestBattle.fight(carl, jon)
        val res = TestBattle.fight(jon, tim)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("8.TestBattle")
    fun `Second Army wins again`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(2, WarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(3,   WarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }






    @ParameterizedTest
    @MethodSource("straightFight")
    fun fight(army1: Army, army2: Army, expected: Boolean) {
        val res1 = Battle.straightFight(army1, army2)
        val res2 = army2.getWarriorAtPosition(0).getHealth

        assertAll(
            { assertEquals(expected, res1, "Fight result is correct") },
            { assertEquals(17, res2, "Check that Healer doesn't heal in a straight fight") }
        )
    }

    companion object {
        @JvmStatic
        fun straightFight(): Stream<Arguments> {
            val army1 = Army()
            army1.addUnits(1,  WarriorType.Lancer)
            army1.addUnits(1,  WarriorType.Knight)
            val army2 = Army()
            army2.addUnits(1,  WarriorType.Lancer)
            army2.addUnits(1,  WarriorType.Vampire)
            army2.addUnits(1,  WarriorType.Healer)
            army2.equipWarriorAtPosition(0, Sword())
            army2.equipWarriorAtPosition(1, MagicWand())

            return Stream.of(
                Arguments.of(army1, army2, false),

                )
        }
    }

}