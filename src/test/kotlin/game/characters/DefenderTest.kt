package game.characters


import game.testCollections.TestArmy
import game.testInteractions.TestBattle
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefenderTest {
    @Test
    @DisplayName("1. Initial for Defender class")
    fun `Does defence parameter work for Defender class`() {
        val warrior1= Knight(Warrior())

        val warrior2 = Defender(Warrior())

        warrior1.hit(warrior2)


        assertEquals(56, warrior2.getHealth)
    }


    @Test
    @DisplayName("1. Fight")
    fun `Warrior attacks first and loses against Defender`() {
        // given
        val carl = Defender(Warrior())
        val tim = Warrior()
        // when
        TestBattle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("2. Fight")
    fun `Defender attacks first and wins against Defender`() {
        // given
        val carl = Warrior()
        val tim = Defender(Warrior())
        // when
        TestBattle.fight(tim, carl)
        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }

    /*
    @ParameterizedTest
    @MethodSource
    fun fight (warrior1: Warrior, warrior2: Warrior, expected: Boolean) {
        val res1 = Battle.fight(warrior1,warrior2)
        val res2 = warrior1.isAlive
        val res3 = warrior2.isAlive

        assertAll(
            { assertEquals(expected,res1, "Fight result is wrong")},
            { assertEquals(expected,res2 , "First warrior isAlive is wrong")},
            { assertEquals(!expected,res3 , "Second warrior isAlive is wrong")}
        )
    }

    companion object {
        @JvmStatic
        fun fight() = listOf {
            Arguments.of( Warrior() , Warrior(), true)
            Arguments.of(Warrior(), Knight(), false)
            Arguments.of(Knight(), Warrior(), true)
            Arguments.of(Knight(), Knight(), true)
        }
    }
    */



    @Test
    @DisplayName("4. Fight")
    fun `Defender wins against Warrior`() {
        // given
        val carl = Defender(Warrior())
        val tim = Warrior()

        // when
        TestBattle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(true, res)
    }

    @Test
    @DisplayName("5. Fight")
    fun `Defender cannot win against Knight`() {
        // given
        val carl = Defender(Warrior())
        val tim = Knight(Warrior())

        // when
        TestBattle.fight(carl, tim)

        val res = carl.isAlive
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("1. Battle")
    fun `TestArmy of warriors losses against TestArmy of defenders`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(20, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(20, "Defender")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("2. Battle")
    fun `TestArmy of warriors loses to TestArmy of defenders`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(20, "Warrior")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(31, "Defender")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(false, res)
    }

    @Test
    @DisplayName("3. Battle")
    fun `Battle mix`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(5, "Warrior")
        firstTestArmy.addUnits(4,"Defender")
        firstTestArmy.addUnits(5,"Defender")
        val secondTestArmy =TestArmy()
        secondTestArmy.addUnits(4, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }


    @Test
    @DisplayName("4. Battle")
    fun `Battle mix 2`() {
        // given
        val firstTestArmy = TestArmy()
        firstTestArmy.addUnits(1, "Warrior")
        firstTestArmy.addUnits(2,"Defender")
        firstTestArmy.addUnits(1,"Defender")
        val secondTestArmy = TestArmy()
        secondTestArmy.addUnits(5, "Warrior")
        // when
        val res = TestBattle.fight(firstTestArmy, secondTestArmy)
        // then
        assertEquals(true, res)
    }
}