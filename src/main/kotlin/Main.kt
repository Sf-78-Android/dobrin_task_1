import game.characters.*
import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle.fight


fun main() {


val  army1 = Army().apply {
  addUnits(1, WarriorType.Warrior)
  addUnits(1, WarriorType.Knight)
  addUnits(1, WarriorType.Lancer)
  addUnits(1, WarriorType.Defender)
  addUnits(1, WarriorType.Healer)
  addUnits(1, WarriorType.Vampire)
}


  val  army2 = Army().apply {
    addUnits(1, WarriorType.Warrior)
    addUnits(1, WarriorType.Knight)
    addUnits(1, WarriorType.Lancer)
    addUnits(3, WarriorType.Defender)
    addUnits(2, WarriorType.Healer)
    addUnits(1, WarriorType.Vampire)
  }

 // check(!Battle.straightFight(army1,army2))
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



 fight(warrior,warrior2)
println(warrior2.toString())
  println(warrior)
}


