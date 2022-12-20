import game.characters.*
import game.collections.Army
import game.collections.Weapons
import game.enums.WarriorType
import game.interactions.Battle
import game.interactions.Battle.fight
import game.weapons.Sword
import game.weapons.Weapon


fun main() {


val  army1 = Army().apply {
  addUnits(1, WarriorType.Lancer)
  addUnits(1, WarriorType.Defender)
  addUnits(1, WarriorType.Healer)
  addUnits(1, WarriorType.Vampire)
}


  val  army2 = Army().apply {
    addUnits(1, WarriorType.Healer)
    addUnits(1, WarriorType.Healer)
    addUnits(3, WarriorType.Healer)
    addUnits(2, WarriorType.Defender)
    addUnits(1, WarriorType.Vampire)
  }
  check(!fight(army1,army2))
  //check(!Battle.straightFight(army1,army2))
 val warrior =  Knight()
val warrior1 = Vampire()
  val warrior2 = Defender()
  val warrior3 = Lancer()
  val warrior4 = Warrior()
  val warrior5 = Healer()

  println(warrior.toString())
  println(warrior1.toString())
  println(warrior2.toString())
  println(warrior3.toString())
  println(warrior4.toString())
  println(warrior5.toString())


val weapon = Weapon(2,3,4,2,3)

  warrior.equipWeapon(weapon)
 fight(warrior,warrior2)
println(warrior2.toString())
  println(warrior)
}


