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

class WeaponsTest {

    @ParameterizedTest
    @MethodSource("testHealthParameter")
    fun testHealthParameter(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {
        warrior.equipWeapon(weapon)
        val res1 = warrior.getHealth
        assertAll(
            { assertEquals(expected, res1, "Warrior health is equal to initial + weapon") },
        )
    }

    @ParameterizedTest
    @MethodSource("testAttackParameter")
    fun testAttackParameter(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {
        warrior.equipWeapon(weapon)
        val res1 = warrior.getAttack
        assertAll(
            { assertEquals(expected, res1, "Warrior attack is equal to initial + weapon") },
        )
    }

    @ParameterizedTest
    @MethodSource("testDefenceParameter")
    fun testDefenceParameter(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {
        warrior.equipWeapon(weapon)
        val res1 = (warrior as Defender).getDefence
        assertAll(
            { assertEquals(expected, res1, "Defender defence is equal to initial + weapon") },
        )
    }

    @ParameterizedTest
    @MethodSource("testVampirismParameter")
    fun testVampirismParameter(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {
        warrior.equipWeapon(weapon)
        val res1 = (warrior as Vampire).getVampirism
        assertAll(
            { assertEquals(expected, res1, "Vampire's vampirism is equal to initial + weapon") },
        )
    }

    @ParameterizedTest
    @MethodSource("testHealingParameter")
    fun testHealingParameter(warrior: BaseWarrior, weapon: BaseWeapon, expected: Int) {
        warrior.equipWeapon(weapon)
        val res1 = (warrior as Healer).getHealingPower
        assertAll(
            { assertEquals(expected, res1, "Healer's healingPower is equal to initial + weapon") },
        )
    }


    companion object {
        @JvmStatic
        fun testHealthParameter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Warrior(), Sword(), 55),
                Arguments.of(Warrior(), GreatAxe(), 35),
                Arguments.of(Warrior(), Katana(), 30),
                Arguments.of(Warrior(), Shield(), 70),
                Arguments.of(Warrior(), MagicWand(), 80),
                Arguments.of(Knight(), Sword(), 55),
                Arguments.of(Knight(), GreatAxe(), 35),
                Arguments.of(Knight(), Katana(), 30),
                Arguments.of(Knight(), Shield(), 70),
                Arguments.of(Knight(), MagicWand(), 80),
                Arguments.of(Lancer(), Sword(), 55),
                Arguments.of(Lancer(), GreatAxe(), 35),
                Arguments.of(Lancer(), Katana(), 30),
                Arguments.of(Lancer(), Shield(), 70),
                Arguments.of(Lancer(), MagicWand(), 80),
                Arguments.of(Defender(), Sword(), 65),
                Arguments.of(Defender(), GreatAxe(), 45),
                Arguments.of(Defender(), Katana(), 40),
                Arguments.of(Defender(), Shield(), 80),
                Arguments.of(Defender(), MagicWand(), 90),
                Arguments.of(Vampire(), Sword(), 45),
                Arguments.of(Vampire(), GreatAxe(), 25),
                Arguments.of(Vampire(), Katana(), 20),
                Arguments.of(Vampire(), Shield(), 60),
                Arguments.of(Vampire(), MagicWand(), 70),
                Arguments.of(Healer(), Sword(), 65),
                Arguments.of(Healer(), GreatAxe(), 45),
                Arguments.of(Healer(), Katana(), 40),
                Arguments.of(Healer(), Shield(), 80),
                Arguments.of(Healer(), MagicWand(), 90)
            )
        }

        @JvmStatic
        fun testDefenceParameter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Defender(), Sword(), 3),
                Arguments.of(Defender(), GreatAxe(), 1),
                Arguments.of(Defender(), Katana(), 0),
                Arguments.of(Defender(), Shield(), 5),
                Arguments.of(Defender(), MagicWand(), 3),

                )
        }

        @JvmStatic
        fun testVampirismParameter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Vampire(), Sword(), 50),
                Arguments.of(Vampire(), GreatAxe(), 60),
                Arguments.of(Vampire(), Katana(), 100),
                Arguments.of(Vampire(), Shield(), 50),
                Arguments.of(Vampire(), MagicWand(), 50),
                Arguments.of(Vampire(), Weapon.Builder().vampirism(-100), 0)

            )
        }

        @JvmStatic
        fun testHealingParameter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Healer(), Sword(), 2),
                Arguments.of(Healer(), GreatAxe(), 2),
                Arguments.of(Healer(), Katana(), 2),
                Arguments.of(Healer(), Shield(), 2),
                Arguments.of(Healer(), MagicWand(), 5),
                Arguments.of(Healer(), Weapon.Builder().healingPower(-100), 0)

            )
        }

        @JvmStatic
        fun testAttackParameter(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Warrior(), Sword(), 7),
                Arguments.of(Knight(), Sword(), 9),
                Arguments.of(Defender(), Sword(), 6),
                Arguments.of(Lancer(), Sword(), 8),
                Arguments.of(Vampire(), Sword(), 6),
                Arguments.of(Healer(), Sword(), 0),
                Arguments.of(Warrior(), GreatAxe(), 10),
                Arguments.of(Knight(), GreatAxe(), 12),
                Arguments.of(Defender(), GreatAxe(), 9),
                Arguments.of(Lancer(), GreatAxe(), 11),
                Arguments.of(Vampire(), GreatAxe(), 9),
                Arguments.of(Healer(), GreatAxe(), 0),
                Arguments.of(Warrior(), Shield(), 4),
                Arguments.of(Knight(), Shield(), 6),
                Arguments.of(Defender(), Shield(), 3),
                Arguments.of(Lancer(), Shield(), 5),
                Arguments.of(Vampire(), Shield(), 3),
                Arguments.of(Healer(), Shield(), 0),
                Arguments.of(Warrior(), MagicWand(), 8),
                Arguments.of(Knight(), MagicWand(), 10),
                Arguments.of(Lancer(), MagicWand(), 9),
                Arguments.of(Defender(), MagicWand(), 7),
                Arguments.of(Vampire(), MagicWand(), 7),
                Arguments.of(Healer(), MagicWand(), 0)

            )
        }
    }


}