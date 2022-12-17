import game.characters.*
import game.collections.Army
import game.interactions.Battle
import game.interactions.Battle.fight
import game.interfaces.BaseWarrior


fun main() {



  var my_army = Army().apply {
   addUnits(2) { Defender(Warrior()) }
   addUnits(1) { Healer(Warrior()) }
   addUnits(2) { Vampire(Warrior()) }
   addUnits(2) { Lancer(Warrior()) }
   addUnits(1) { Healer(Warrior()) }
   addUnits(1) { Warrior() }
  }

  var enemy_army = Army().apply {
   addUnits(2) { Warrior() }
   addUnits(4) { Lancer(Warrior()) }
   addUnits(1) { Healer(Warrior()) }
   addUnits(2) { Defender(Warrior()) }
   addUnits(3) { Vampire(Warrior()) }
   addUnits(1) { Healer(Warrior()) }
  }
  var army_3 = Army().apply {
   addUnits(1) { Warrior() }
   addUnits(1) { Lancer(Warrior()) }
   addUnits(1) { Healer(Warrior()) }
   addUnits(2) { Defender(Warrior()) }
  }

  var army_4 = Army().apply {
   addUnits(3) { Vampire(Warrior()) }
   addUnits(1) { Warrior() }
   addUnits(1) { Healer(Warrior()) }
   addUnits(2) { Lancer(Warrior()) }
  }

  check(fight(my_army, enemy_army) == false)
  check(fight(army_3, army_4) == true)
  println("OK")


}


