package game.characters

import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
import game.testInteractions.Battle
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
        val res = Battle.fight(carl, jon)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Knight dies after more than one Battle`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        val jon = Knight()
        // when
        Battle.fight(jon, carl)
        Battle.fight(jon, tim)
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
        Battle.fight(tim, carl)
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
        Battle.fight(tim, jon)
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
        Battle.fight(tim, carl)
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
        Battle.fight(carl, jon)
        val res = Battle.fight(jon, tim)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("7.Battle")
    fun `Second Army wins`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(1, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(2, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("8.Battle")
    fun `Second Army wins again`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(2, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(3, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("9. Battle")
    fun `Second Army wins for third time`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(5, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(7, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("10. Battle")
    fun `First Army wins`() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(20, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(21, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("11. Battle")
    fun `First Army wins `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Warrior)
        val secondArmy = TestArmy()
        secondArmy.addUnits(7, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("12. Battle")
    fun `First Army wins with Knights `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Knight)
        val secondArmy = TestArmy()
        secondArmy.addUnits(12, TestWarriorType.Warrior)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
    @Test
    @DisplayName("12. Battle")
    fun `First one hit, first one wins `() {
        // given
        val firstArmy = TestArmy()
        firstArmy.addUnits(11, TestWarriorType.Knight)
        val secondArmy = TestArmy()
        secondArmy.addUnits(11, TestWarriorType.Knight)
        // when
        val res = Battle.fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }



}