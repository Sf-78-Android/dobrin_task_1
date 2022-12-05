import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CharacterKtTest {
    @Test
    @DisplayName("1. Fight")
    fun `Warrior loses when fights against Knight`() {
        // given
        val carl = Warrior()
        val jon = Knight()
        // when
        val res = fight(carl, jon)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Knight dies after more than one battle`() {
        // given
        val carl = Warrior()
        val tim = Warrior()
        val jon = Knight()
        // when
        fight(jon, carl)
        fight(jon, tim)
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
        fight(tim, carl)
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
        fight(tim, jon)
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
        fight(tim, carl)
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
        fight(carl, jon)
        val res = fight(jon, tim)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("7.Battle")
    fun `Second army wins`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(1, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(2, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("8.Battle")
    fun `Second army wins again`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(2, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(3, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("9. Battle")
    fun `Second army wins for third time`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(5, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(7, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("10. Battle")
    fun `First army wins`() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(20, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(21, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("11. Battle")
    fun `First army wins `() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(11, ::Warrior)
        val secondArmy = Army()
        secondArmy.addUnits(7, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("12. Battle")
    fun `First army wins with Knights `() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(11, ::Knight)
        val secondArmy = Army()
        secondArmy.addUnits(12, ::Warrior)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
    @Test
    @DisplayName("12. Battle")
    fun `First one hit, first one wins `() {
        // given
        val firstArmy = Army()
        firstArmy.addUnits(11, ::Knight)
        val secondArmy = Army()
        secondArmy.addUnits(11, ::Knight)
        // when
        val res = fight(firstArmy, secondArmy)
        // then
        assertEquals(true, res)
    }
}