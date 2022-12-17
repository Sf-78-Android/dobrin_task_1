package game.characters

import game.testCollections.TestArmy
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class WarriorKtTest {
    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        // given
        val carl = Warrior()
        val jon = Knight(Warrior())
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
        val jon = Knight(Warrior())
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
        val tim = Knight(Warrior())
        val jon = Knight(Warrior())
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
        val jon = Knight(Warrior())
        // when
        TestBattle.fight(carl, jon)
        val res = TestBattle.fight(jon, tim)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("7.TestBattle")
    fun `Second TestArmy wins`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(1, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(2, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("8.TestBattle")
    fun `Second TestArmy wins again`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(2, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(3, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("9. TestBattle")
    fun `Second TestArmy wins for third time`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(5, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(7, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("10. TestBattle")
    fun `First TestArmy wins`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(20, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(21, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("11. TestBattle")
    fun `First TestArmy wins `() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(11, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(7, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("12. TestBattle")
    fun `First TestArmy wins with Knights `() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(11, "Knight")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(12, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }
    @Test
    @DisplayName("12. TestBattle")
    fun `First one hit, first one wins `() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(11, "Knight")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(11, "Knight")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }



}