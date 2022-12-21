package game.tests

import game.characters.*
import game.testCollections.TestArmy
import game.testEnum.TestWarriorType
import game.testInteractions.TestBattle
import game.weapons.*

object Functional {
    fun main() {
        var ogre = Warrior()
        var lancelot = Knight()
        var richard = Defender()
        var eric = Vampire()
        var freelancer = Lancer()
        var priest = Healer()

        var sword = Sword()
        var shield = Shield()
        var axe = GreatAxe()
        var katana = Katana()
        var wand = MagicWand()
        // consider using a builder instead
        var superWeapon = Weapon.Builder(50, 10, 5, 150, 8)


        ogre.equipWeapon(shield)
        ogre.equipWeapon(superWeapon)
        lancelot.equipWeapon(superWeapon)
        richard.equipWeapon(shield)
        eric.equipWeapon(superWeapon)
        freelancer.equipWeapon(axe)
        freelancer.equipWeapon(katana)
        priest.equipWeapon(wand)
        priest.equipWeapon(shield)

        assert(ogre.getHealth == 125)
        assert(lancelot.getAttack == 17)
        assert(richard.getDefence == 4)
        assert(eric.getVampirism == 200)
        assert(freelancer.getHealth  == 15)
        assert(priest.getHealingPower == 5)

        assert(TestBattle.fight (ogre, eric) == false)
        assert(TestBattle.fight (priest, richard) == false)
        assert(TestBattle.fight(lancelot, freelancer) == true)

        var myArmy = TestArmy()
        myArmy.addUnits(1, TestWarriorType.Knight)
        myArmy.addUnits(1, TestWarriorType.Lancer)

        var enemyArmy = TestArmy()
        enemyArmy.addUnits(1, TestWarriorType.Vampire)
        enemyArmy.addUnits(1, TestWarriorType.Healer)

        myArmy.equipWarriorAtPosition(0, axe)
        myArmy.equipWarriorAtPosition(1, superWeapon)

        enemyArmy.equipWarriorAtPosition(0, katana)
        enemyArmy.equipWarriorAtPosition(1, wand)

        assert(TestBattle.fight(myArmy, enemyArmy) == true)
    }
}