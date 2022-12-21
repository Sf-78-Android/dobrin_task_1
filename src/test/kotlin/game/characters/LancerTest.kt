package game.characters

import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
import game.testInteractions.Battle.fight
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class LancerTest {
    @Test
    @DisplayName("1. Battle")
    fun `Check Lancer pierce by killing two Rookies with one hit`() {
        // given
        val Army1 = TestArmy()
        val Army2 = TestArmy()
       Army1.addUnits(1, TestWarriorType.Warrior)
       Army2.addUnits(1,TestWarriorType.Lancer)
        // when

        val res = fight(Army2,Army1)
        // then
        assertEquals(true,res)
    }


    @Test
    @DisplayName("2 Battle")
    fun `Check Lancer pierce by killing one Vampire and Defender takes damage minus defence`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(1, TestWarriorType.Lancer)
        val secondArmy = TestArmy()
        secondArmy.addUnits(1, TestWarriorType.Warrior)
        secondArmy.addUnits(1, TestWarriorType.Vampire)
        // when
        val res = fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }


    @Test
    @DisplayName("3. Battle")
    fun `Second Army should win`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(15, TestWarriorType.Lancer)
        firstArmy.addUnits(15, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(20, TestWarriorType.Defender)
        secondArmy.addUnits(20, TestWarriorType.Knight)
        // when
        val res = fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    @DisplayName("4. Battle")
    fun `First Army wins in a Battle between Lancers`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(5, TestWarriorType.Lancer)

        val secondArmy = TestArmy()
        secondArmy.addUnits(3, TestWarriorType.Defender)

        // when
        val res = fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Battle")
    fun `Second Army wins in a Battle between Lancers`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(15, TestWarriorType.Lancer)

        val secondArmy = TestArmy()
        secondArmy.addUnits(18, TestWarriorType.Lancer)

        // when
        val res = fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    @DisplayName("6. Battle")
    fun `Lancer kills rookie and continues to fight`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(1, TestWarriorType.Lancer)

        val secondArmy = TestArmy()
        secondArmy.addUnits(1, TestWarriorType.Defender)

        // when
        val res = fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    fun `Lancer should damage the fighter from third position if the second is killed`() {


        val army1 = TestArmy().apply {
            addUnits(1, TestWarriorType.Warrior)
            addUnits(9, TestWarriorType.Rookie)
        }
        val army2 = TestArmy().apply {
            addUnits(1, TestWarriorType.Lancer)
        }

        val res = fight(army1,army2)

        assertFalse(res, "Lancer should have won")
    }




}