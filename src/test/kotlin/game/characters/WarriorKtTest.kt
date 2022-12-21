package game.characters

import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
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
        val jon = Knight()
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
        val jon = Knight()
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
        val tim = Knight()
        val jon = Knight()
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
        val jon = Knight()
        // when
        TestBattle.fight(carl, jon)
        val res = TestBattle.fight(jon, tim)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("7.TestBattle")
    fun `Second Army wins`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(1, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(2, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("8.TestBattle")
    fun `Second Army wins again`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(2, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(3, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("9. TestBattle")
    fun `Second Army wins for third time`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(5, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(7, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("10. TestBattle")
    fun `First Army wins`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(20, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(21, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("11. TestBattle")
    fun `First Army wins `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(7, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("12. TestBattle")
    fun `First Army wins with Knights `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Knight)
        val secondArmy = TestArmy()
        secondArmy.addUnits(12, TestWarriorType.Warrior)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
    @Test
    @DisplayName("12. TestBattle")
    fun `First one hit, first one wins `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Knight)
        val secondArmy = TestArmy()
        secondArmy.addUnits(11, TestWarriorType.Knight)
        // when
        val res = TestBattle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }



}