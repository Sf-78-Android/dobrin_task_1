package test.game.characters

import game.testCollections.TestArmy
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class LancerTest {
    @Test
    @DisplayName("1. TestBattle")
    fun `Check Lancer pierce by killing two Rookies with one hit`() {
        // given
        val TestArmy1 = TestArmy()
        val TestArmy2 = TestArmy()
       TestArmy1.addUnits(1,"Rookie")
       TestArmy1.addUnits(1,"Rookie")
       TestArmy2.addUnits(1,"Lancer")
        // when

        val res = TestBattle.fight(TestArmy2,TestArmy1)
        // then
        assertEquals(true,res)
    }


    @Test
    @DisplayName("2 TestBattle")
    fun `Check Lancer pierce by killing one Vampire and Defender takes damage minus defence`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(20, "Lancer")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(20, "Defender")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        //assert
        assertEquals(true, res)
    }


    @Test
    @DisplayName("3. TestBattle")
    fun `Second TestArmy should win`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(15, "Lancer")
        firstTestArmy.addUnits(15, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(20, "Defender")
        secondTestArmy.addUnits(20, "Knight")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("4. TestBattle")
    fun `First TestArmy wins in a TestBattle between Lancers`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(5, "Lancer")

        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(3, "Defender")

        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. TestBattle")
    fun `Second TestArmy wins in a TestBattle between Lancers`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(15, "Lancer")

        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(18, "Lancer")

        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("6. TestBattle")
    fun `Lancer kills rookie and continues to fight`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(1, "Lancer")

        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(1, "Defender")
        secondTestArmy.addUnits(1, "Rookie")

        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        //assert
        assertEquals(true, res)
    }
}