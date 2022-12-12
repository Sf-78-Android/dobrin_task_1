package game.characters

import game.collections.Army
import game.interactions.Battle
import game.testClass.Rookie
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class LancerTest {
    @Test
    @DisplayName("1. Battle")
    fun `Check Lancer pierce by killing two Rookies with one hit`() {
        // given
        val army1 = Army()
        val army2 = Army()
        army1.addUnits(1,::Rookie)
        army1.addUnits(1,::Rookie)
        army2.addUnits(1,::Lancer)
        // when

        val res = Battle.fight(army2,army1)
        // then
        assertEquals(true,res)
    }


    @Test
    @DisplayName("2 Battle")
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
    @DisplayName("3. Battle")
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
    @DisplayName("4. Battle")
    fun `First army wins in a battle between Lancers`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(5, ::Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(3, ::Defender)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Battle")
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
    @DisplayName("6. Battle")
    fun `Lancer kills rookie and continues to fight`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(1, ::Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(1, ::Defender)
        secondArmy.addUnits(1, ::Rookie)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }
}