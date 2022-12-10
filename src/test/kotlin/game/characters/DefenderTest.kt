package game.characters

import game.collections.Army
import game.interactions.Battle
import game.settings.Params
import game.testClass.Rookie
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefenderTest {
    @Test
    @DisplayName("1. Initial for Defender class")
    fun `Does defence parameter work for Defender class`() {
        val warrior1= Knight()

        val warrior2 = Defender()

        warrior1.hit(warrior2)


        assertEquals(56, warrior2.health)
    }


    @Test
    @DisplayName("1. Fight")
    fun `Warrior attacks first and loses against Defender`() {
        // given
        val carl = Defender()
        val tim = Warrior(Params.Defender.HEALTH)
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
        val carl = Defender()
        val tim = Defender()
        // when
        Battle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }
    @Test
    @DisplayName("3. Fight")
    fun `Defender does not take damage`() {
        // given
        val carl = Defender()
        val tim = Rookie()
        // when
        Battle.fight(carl, tim)
        val res = carl.health
        // then
        assertEquals(60, res)
    }


    @Test
    @DisplayName("4. Fight")
    fun `Defender wins against Warrior`() {
        // given
        val carl = Defender()
        val tim = Warrior(Params.Defender.HEALTH)

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
        val carl = Defender()
        val tim = Knight()

        // when
        Battle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("1. Battle")
    fun `Army of warriors losses against army of defenders`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(20, ::Defender)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Battle")
    fun `Army of warriors loses to army of defenders`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(31, ::Defender)
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
        firstArmy.addUnits(5, ::Warrior)
        firstArmy.addUnits(4,::Defender)
        firstArmy.addUnits(5,::Defender)
        val secondArmy = Army()
        secondArmy.addUnits(4, ::Warrior)
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
        firstArmy.addUnits(1, ::Warrior)
        firstArmy.addUnits(2,::Defender)
        firstArmy.addUnits(1,::Defender)
        val secondArmy = Army()
        secondArmy.addUnits(5, ::Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }
}