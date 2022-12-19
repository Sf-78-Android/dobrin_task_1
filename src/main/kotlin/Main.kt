import game.collections.Army
import game.enums.WarriorType
import game.factory.getWarrior
import game.interactions.Battle


fun main() {


val  army1 = Army().apply {
  addUnits(2, WarriorType.Warrior)
  addUnits(2, WarriorType.Knight)
  addUnits(2, WarriorType.Lancer)
  addUnits(2, WarriorType.Defender)
  addUnits(2, WarriorType.Healer)
  addUnits(2, WarriorType.Vampire)
}


  val  army2 = Army().apply {
    addUnits(10, WarriorType.Warrior)
    addUnits(100, WarriorType.Knight)
    addUnits(1, WarriorType.Lancer)
    addUnits(1, WarriorType.Defender)
    addUnits(1, WarriorType.Healer)
    addUnits(1, WarriorType.Vampire)
  }

 check(!Battle.fight(army1,army2))
  val chuck = getWarrior(WarriorType.Warrior)
  val pete = getWarrior(WarriorType.Vampire)

  check(Battle.fight(chuck,pete))
  println("OK")


}


