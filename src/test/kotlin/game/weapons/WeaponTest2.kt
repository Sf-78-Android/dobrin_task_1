package game.weapons

import game.characters.*
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class WeaponTest2 {


    @ParameterizedTest
    @MethodSource("warriorIsDead")
    fun warriorIsDead(warrior: BaseWarrior, weapon: BaseWeapon, expected: Boolean) {

        warrior.equipWeapon(weapon)
        val res1 = warrior.isAlive

        assertAll(
            { assertEquals(expected, res1, "Warrior is dead") }
        )
    }

    @ParameterizedTest
    @MethodSource("testNullParameters")
    fun testNullParameters(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {

        warrior.equipWeapon(weapon)
        val res1 = warrior.getHealth
        assertAll(
            { assertEquals(expected, res1, "Warrior has zero health added by weapon") }

        )

    }

    companion object {
        @JvmStatic
        fun warriorIsDead(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Knight(), Weapon.Builder().health(-100), false),
                Arguments.of(Healer(), Weapon.Builder().health(-100), false),
                Arguments.of(Defender(), Weapon.Builder().health(-100), false),
                Arguments.of(Warrior(), Weapon.Builder().health(-100), false),
                Arguments.of(Lancer(), Weapon.Builder().health(-100), false),
                Arguments.of(Vampire(), Weapon.Builder().health(-100), false)
            )
        }
        @JvmStatic
        fun testNullParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Knight(), Weapon.Builder().vampirism(5), 50),
                Arguments.of(Healer(), Weapon.Builder().vampirism(5), 60),
                Arguments.of(Defender(), Weapon.Builder().vampirism(5), 60),
                Arguments.of(Warrior(), Weapon.Builder().vampirism(5), 50),
                Arguments.of(Lancer(), Weapon.Builder().vampirism(5), 50),
                Arguments.of(Vampire(), Weapon.Builder().healingPower(5), 40),

            )
        }
    }
}