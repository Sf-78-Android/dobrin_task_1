package game.characters

import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle

import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class LancerTest {
    @Test
    @DisplayName("1. Battle")
    fun `Check Lancer pierce by killing two Rookies with one hit`() {
        // given
        val Army1 = Army()
        val Army2 = Army()
       Army1.addUnits(1, WarriorType.Warrior)
       Army2.addUnits(1,WarriorType.Lancer)
        // when

        val res = Battle.fight(Army2,Army1)
        // then
        assertEquals(true,res)
    }


    @Test
    @DisplayName("2 Battle")
    fun `Check Lancer pierce by killing one Vampire and Defender takes damage minus defence`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(1, WarriorType.Lancer)
        val secondArmy = Army()
        secondArmy.addUnits(1, WarriorType.Warrior)
        secondArmy.addUnits(1, WarriorType.Vampire)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }


    @Test
    @DisplayName("3. Battle")
    fun `Second Army should win`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(15, WarriorType.Lancer)
        firstArmy.addUnits(15, WarriorType.Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(20, WarriorType.Defender)
        secondArmy.addUnits(20, WarriorType.Knight)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }

    @Test
    @DisplayName("4. Battle")
    fun `First Army wins in a Battle between Lancers`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(5, WarriorType.Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(3, WarriorType.Defender)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Battle")
    fun `Second Army wins in a Battle between Lancers`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(15, WarriorType.Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(18, WarriorType.Lancer)

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
        firstArmy.addUnits(1, WarriorType.Lancer)

        val secondArmy = Army()
        secondArmy.addUnits(1, WarriorType.Defender)

        // when
        val res = Battle.fight(firstArmy, secondArmy)
        //assert
        assertEquals(false, res)
    }
}