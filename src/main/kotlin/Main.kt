import game.characters.Knight
import game.characters.Warrior
import game.collections.Army
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.settings.Params


fun main() {


 fun smokeTestOne() {

  val chuck = Warrior()
  val bruce = Warrior()

  check(Battle.fight(chuck, bruce) == true) { "entities.Warrior should win entities.Warrior" }
  check(chuck.isAlive == true) { "entities.Warrior winner should be alive " }
  check(bruce.isAlive == false) { "entities.Warrior winner should not be alive " }
  val carl = Knight(Warrior())
  val dave = Warrior()
  check(Battle.fight(dave, carl) == false) { "entities.Warrior should lose to entities.Knight" }
  check(carl.isAlive == true) { "entities.Knight winner should be alive " }
  check(dave.isAlive == false) { "entities.Warrior defeated should not be alive " }
  println("ONE OK")
 }

 smokeTestOne()


}

