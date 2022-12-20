package game.characters


import game.collections.Army
import game.enums.FightType
import game.enums.WarriorType
import game.interactions.Battle
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class VampireTest {

    @Test
    @DisplayName("Test Vampire class")
    fun `Does vampirism parameter work for Defender class`() {
        val warrior1 = Vampire()

        val warrior2 = Warrior()

        warrior2.hit(warrior1,FightType.Classic)
        warrior1.hit(warrior2, FightType.Classic)

        val res = warrior1.getHealth

        assertEquals(37, res)
    }

    @Test
    @DisplayName("Test Vampire class2")
    fun `Does vampirism parameter work for Warrior class`() {
        val warrior1 = Vampire()

        val warrior2 = Warrior()

        warrior2.hit(warrior1,FightType.Classic)
        warrior1.hit(warrior2, FightType.Classic)

        val res = warrior1.getHealth == 37

        assertEquals(true, res)
    }

    @Test
    @DisplayName("1. Fight")
    fun `Vampire  wins against Warrior`() {
        // given
        val carl = Vampire()
        val tim = Warrior()

        // when
        Battle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Vampire  losses against Knight`() {
        // given
        val carl = Vampire()
        val tim = Knight()

        // when
        Battle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }


    @Test
    @DisplayName("1. Battle")
    fun `Vampires win`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, WarriorType.Vampire)
        val secondArmy = Army()
        secondArmy.addUnits(11, WarriorType.Knight)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
}