package game.characters


import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefenderTest {
    @Test
    @DisplayName("1. Initial for Defender class")
    fun `Does defence parameter work for Defender class`() {
        val warrior1 = Knight(Warrior())

        val warrior2 = Defender(Warrior())

        warrior1.hit(warrior2)


        assertEquals(56, warrior2.getHealth)
    }


    @Test
    @DisplayName("1. Fight")
    fun `Warrior attacks first and loses against Defender`() {
        // given
        val carl = Defender(Warrior())
        val tim = Warrior()
        // when
        Battle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Defender attacks first and wins against Defender`() {
        // given
        val carl = Warrior()
        val tim = Defender(Warrior())
        // when
        Battle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }

    /*
    @ParameterizedTest
    @MethodSource
    fun fight (warrior1: Warrior, warrior2: Warrior, expected: Boolean) {
        val res1 = Battle.fight(warrior1,warrior2)
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
    */


    @Test
    @DisplayName("4. Fight")
    fun `Defender wins against Warrior`() {
        // given
        val carl = Defender(Warrior())
        val tim = Warrior()

        // when
        Battle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Defender cannot win against Knight`() {
        // given
        val carl = Defender(Warrior())
        val tim = Knight(Warrior())

        // when
        Battle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("1. Battle")
    fun `Army of warriors losses against Army of defenders`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, WarriorType.Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(20, WarriorType.Defender)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Battle")
    fun `Army of warriors loses to Army of defenders`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, WarriorType.Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(31, WarriorType.Defender)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Battle")
    fun `Battle mix`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(5, WarriorType.Warrior)
        firstArmy.addUnits(4, WarriorType.Defender)
        firstArmy.addUnits(5, WarriorType.Defender)
        val secondArmy = Army()
        secondArmy.addUnits(4, WarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }


    @Test
    @DisplayName("4. Battle")
    fun `Battle mix 2`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(1, WarriorType.Warrior)
        firstArmy.addUnits(2, WarriorType.Defender)
        firstArmy.addUnits(1, WarriorType.Defender)
        val secondArmy = Army()
        secondArmy.addUnits(5, WarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
}