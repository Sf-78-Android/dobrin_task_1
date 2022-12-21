import game.characters.*
import game.collections.Army
import game.collections.Weapons
import game.enums.WarriorType
import game.interactions.Battle
import game.interactions.Battle.fight
import game.interfaces.BaseWeapon
import game.weapons.*


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
  var superWeapon = Weapon.Builder()
      .health(100)
      .attack(200)
      .defence(300)
      .vampirism(200)
      .healingPower(100)

 var anotherWeapon = Weapon.Builder()
   .health(50)
   .attack(20)
   .defence(5)
   .vampirism(150)



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

  assert(fight (ogre, eric) == false)
  assert(fight (priest, richard) == false)
  assert(fight(lancelot, freelancer) == true)

  var myArmy = Army()
  myArmy.addUnits(1, WarriorType.Knight)
  myArmy.addUnits(1, WarriorType.Lancer)

  var enemyArmy = Army()
  enemyArmy.addUnits(1, WarriorType.Vampire)
  enemyArmy.addUnits(1, WarriorType.Healer)

  myArmy.equipWarriorAtPosition(0, axe)
  myArmy.equipWarriorAtPosition(1, superWeapon)

  enemyArmy.equipWarriorAtPosition(0, katana)
  enemyArmy.equipWarriorAtPosition(1, wand)

  assert(fight(myArmy, enemyArmy) == true)

  println("OK")
}


