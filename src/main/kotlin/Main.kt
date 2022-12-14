import game.characters.*
import game.collections.Army
import game.interactions.Battle

//TODO fix smoke tests
fun main() {


 fun smokeTestOne() {

  val chuck = Warrior()
  val bruce = Warrior()

  check(Battle.fight(chuck, bruce) == true) // "entities.Warrior should win entities.Warrior"
  check(chuck.isAlive == true) //entities.Warrior winner should be alive "
  check(bruce.isAlive == false)// "entities.Warrior winner should not be alive "
  val carl = Knight(Warrior())
  val dave = Warrior()
  check(Battle.fight(dave, carl) == false) // "entities.Warrior should lose to entities.Knight"
  check(carl.isAlive == true)// "entities.Knight winner should be alive "
  check(dave.isAlive == false) //"entities.Warrior defeated should not be alive "
  println("ONE OK")
 }

 fun smokeTestTwo() {


  val myArmy = Army()
  myArmy.addUnits(3, "Knight")


  val enemyArmy = Army()
  enemyArmy.addUnits(3, "warrioR")

  val army3 = Army()
  army3.addUnits(20, "warrioR")
  army3.addUnits(5, "Knight")

  val army4 = Army()
  army4.addUnits(30, "Knight")

  check(Battle.fight(myArmy, enemyArmy) == true)
  check(Battle.fight(army3, army4) == false)
  println("TWO OK")

 }

 fun smokeTestDefender() {
  val chuck = Warrior()
  val bruce = Warrior()
  val carl = Knight(Warrior())
  val dave = Warrior()
  val mark = Warrior()
  val bob = Defender(Warrior())
  val mike = Knight(Warrior())
  val rog = Warrior()
  val lancelot = Defender(Warrior())

  assert(Battle.fight(chuck, bruce) == true)
  assert(Battle.fight(dave, carl) == false)
  assert(chuck.isAlive == true)
  assert(bruce.isAlive == false)
  assert(carl.isAlive == true)
  assert(dave.isAlive == false)
  assert(Battle.fight(carl, mark) == false)
  assert(carl.isAlive == false)
  assert(Battle.fight(bob, mike) == false)
  assert(Battle.fight(lancelot, rog) == true)

  val myArmy = Army()
  myArmy.addUnits(1, "DefEndeR")

  val enemyArmy = Army()
  enemyArmy.addUnits(2, "warrioR")

  val army3 = Army()
  army3.addUnits(1, "warrioR")
  army3.addUnits(1, "DefEndeR")

  val army4 = Army()
  army4.addUnits(2, "warrioR")

  assert(Battle.fight(myArmy, enemyArmy) == false)
  assert(Battle.fight(army3, army4) == true)
  println("DEFENDERS OK")

 }

 fun smokeTestVampires() {
  val chuck = Warrior()
  val bruce = Warrior()
  val carl = Knight(Warrior())
  val dave = Warrior()
  val mark = Warrior()
  val bob = Defender(Warrior())
  val mike = Knight(Warrior())
  val rog = Warrior()
  val lancelot = Defender(Warrior())
  val eric = Vampire(Warrior())
  val adam = Vampire(Warrior())
  val richard = Defender(Warrior())
  val ogre = Warrior()

  assert(Battle.fight(chuck, bruce) == true)
  assert(Battle.fight(dave, carl) == false)
  assert(chuck.isAlive == true)
  assert(bruce.isAlive == false)
  assert(carl.isAlive == true)
  assert(dave.isAlive == false)
  assert(Battle.fight(carl, mark) == false)
  assert(carl.isAlive == false)
  assert(Battle.fight(bob, mike) == true)
  assert(Battle.fight(lancelot, rog) == true)
  assert(Battle.fight(eric, richard) == true)
  assert(Battle.fight(ogre, adam) == false)

  val myArmy = Army()
  myArmy.addUnits(2, "DefEndeR")
  myArmy.addUnits(2, "vampire")
  myArmy.addUnits(1, "warrioR")

  val enemyArmy = Army()
  enemyArmy.addUnits(2, "warrioR")
  enemyArmy.addUnits(2, "DefEndeR")
  enemyArmy.addUnits(3, "vampire")

  val army3 = Army()
  army3.addUnits(1, "warrioR")
  army3.addUnits(4, "DefEndeR")

  val army4 = Army()
  army4.addUnits(3, "vampire")
  army4.addUnits(2, "warrioR")

  assert(Battle.fight(myArmy, enemyArmy) == false)
  assert(Battle.fight(army3, army4) == true)
  println("VAMPIRES OK")

 }

 fun smokeTestLancers() {
  val chuck = Warrior()
  val bruce = Warrior()
  val carl = Knight(Warrior())
  val dave = Warrior()
  val mark = Warrior()
  val bob = Defender(Warrior())
  val mike = Knight(Warrior())
  val rog = Warrior()
  val lancelot = Defender(Warrior())
  val eric = Vampire(Warrior())
  val adam = Vampire(Warrior())
  val richard = Defender(Warrior())
  val ogre = Warrior()
  val freelancer = Lancer(Warrior())
  val vampire = Vampire(Warrior())

  check(Battle.fight(chuck, bruce) == true)
  check(Battle.fight(dave, carl) == false)
  check(chuck.isAlive == true)
  check(bruce.isAlive == false)
  check(carl.isAlive == true)
  check(dave.isAlive == false)
  check(Battle.fight(carl, mark) == false)
  check(carl.isAlive == false)
  check(Battle.fight(bob, mike) == false)
  check(Battle.fight(lancelot, rog) == true)
  check(Battle.fight(eric, richard) == false)
  check(Battle.fight(ogre, adam) == true)
  check(Battle.fight(freelancer, vampire) == true)
  check(freelancer.isAlive == true)

  val myArmy = Army()
  myArmy.addUnits(2, "Defender")
  myArmy.addUnits(2, "vampire")
  myArmy.addUnits(4, "lancer")
  myArmy.addUnits(1, "warrior")

  val enemyArmy = Army()
  enemyArmy.addUnits(2, "warrior")
  enemyArmy.addUnits(2, "lancer")
  enemyArmy.addUnits(2, "Defender")
  enemyArmy.addUnits(3, "vampire")

  val army3 = Army()
  army3.addUnits(1, "warrior")
  army3.addUnits(1, "lancer")
  army3.addUnits(2, "Defender")

  val army4 = Army()
  army4.addUnits(3, "vampire")
  army4.addUnits(1, "warrior")
  army4.addUnits(2, "lanceR")

  check(Battle.fight(myArmy, enemyArmy) == true)
  check(Battle.fight(army3, army4) == false)
  println("LANCERS OK")

 }
 smokeTestOne()
 smokeTestTwo()
 smokeTestDefender()
 smokeTestVampires()
 smokeTestLancers()
}

