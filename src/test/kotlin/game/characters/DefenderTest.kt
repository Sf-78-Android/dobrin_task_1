package game.characters


import game.enums.FightType
import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefenderTest {
    @Test
    @DisplayName("1. Initial for Defender class")
    fun `Does defence parameter work for Defender class`() {
        val warrior1 = Knight()

        val warrior2 = Defender()

        warrior1.hit(warrior2, FightType.Classic)


        assertEquals(56, warrior2.getHealth)
    }


    @Test
    @DisplayName("1. Fight")
    fun `Warrior attacks first and loses against Defender`() {
        // given
        val carl = Defender()
        val tim = Warrior()
        // when
        TestBattle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Defender attacks first and wins against Defender`() {
        // given
        val carl = Warrior()
        val tim = Defender()
        // when
        TestBattle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }



    @Test
    @DisplayName("4. Fight")
    fun `Defender wins against Warrior`() {
        // given
        val carl = Defender()
        val tim = Warrior()

        // when
        TestBattle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Defender cannot win against Knight`() {
        // given
        val carl = Defender()
        val tim = Knight()

        // when
        TestBattle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("1. Battle")
    fun `Army of warriors losses against Army of defenders`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(20, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(20, TestWarriorType.Defender)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Battle")
    fun `Army of warriors loses to Army of defenders`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(20, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(31, TestWarriorType.Defender)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Battle")
    fun `Battle mix`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(5, TestWarriorType.Warrior)
        firstArmy.addUnits(4, TestWarriorType.Defender)
        firstArmy.addUnits(5, TestWarriorType.Defender)
        val secondArmy = TestArmy()
        secondArmy.addUnits(4, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }


    @Test
    @DisplayName("4. Battle")
    fun `Battle mix 2`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(1, TestWarriorType.Warrior)
        firstArmy.addUnits(2, TestWarriorType.Defender)
        firstArmy.addUnits(1, TestWarriorType.Defender)
        val secondArmy = TestArmy()
        secondArmy.addUnits(5, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }



    @ParameterizedTest
    @MethodSource
    fun fight (warrior1: Warrior, warrior2: Warrior, expected: Boolean) {
        val res1 = TestBattle.fight(warrior1,warrior2)
        val res2 = warrior1.isAlive
        val res3 = warrior2.isAlive

        assertAll(
            { assertEquals(expected,res1, "Fight result is wrong")},
            { assertEquals(expected,res2 , "First warrior isAlive is wrong")},
            { assertEquals(!expected,res3 , "Second warrior isAlive is wrong")}
        )
    }

    companion object {
        @JvmStatic
        fun fight() = listOf {
            Arguments.of( Warrior() , Warrior(), true)
            Arguments.of(Warrior(), Knight(), false)
            Arguments.of(Knight(), Warrior(), true)
            Arguments.of(Knight(), Knight(), true)
        }
    }
}
