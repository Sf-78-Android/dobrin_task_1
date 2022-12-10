package game.characters

import game.collections.Army
import game.interactions.Battle
import game.testClass.Rookie
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class LancerTest {
    @Test
    @DisplayName("1. Fight")
    fun `Check Lancer pierce by killing two Rookies with one hit`() {
        // given
        val carl = Rookie()
        val tim = Rookie()
        val dom = Lancer()
        // when
     //   dom.hitAndPierce(carl,tim)
        val res = carl.isAlive && dom.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Check Lancer pierce by killing one Rookie and Defender takes damage minus defence`() {
        // given
        val carl = Defender()
        val tim = Rookie()
        val dom = Lancer()
        // when
       // dom.hitAndPierce(carl,tim)
        val res = carl.health == 56 && !tim.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("1. Battle")
    fun `Check Lancer pierce by killing one Vampire and Defender takes damage minus defence`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, ::Lancer)
        val secondArmy = Army()
        secondArmy.addUnits(20, ::Defender)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }


    @Test
    @DisplayName("2. Battle")
    fun `Second army should win`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(15, ::Lancer)
        firstArmy.addUnits(15, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(20, ::Defender)
        secondArmy.addUnits(20, ::Knight)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Battle")
    fun `First army wins in a battle between Lancers`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(15, ::Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(15, ::Lancer)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("4. Battle")
    fun `Second army wins in a battle between Lancers`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(15, ::Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(18, ::Lancer)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    @DisplayName("5. Battle")
    fun `Army with one Lancer wins another with one Lancer`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(1, ::Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(1, ::Lancer)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }
}