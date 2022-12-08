import characters.Defender
import characters.Knight
import characters.Vampire
import characters.Warrior
import collections.Army
import interactions.Battle.fight


fun main(args: Array<String>) {



 fun smokeTestOne(){

     val chuck = Warrior()
     val bruce = Warrior()

     check(fight(chuck,bruce) == true) {"entities.Warrior should win entities.Warrior"}
     check(chuck.isAlive == true) {"entities.Warrior winner should be alive "}
     check(bruce.isAlive == false) {"entities.Warrior winner should not be alive "}
     val carl = Knight()
     val dave = Warrior()
     check(fight(dave,carl) == false) {"entities.Warrior should lose to entities.Knight"}
     check(carl.isAlive == true) {"entities.Knight winner should be alive "}
     check(dave.isAlive == false) {"entities.Warrior defeated should not be alive "}
     println("ONE OK")
 }


 fun smokeTestTwo() {


  val myArmy = Army()
  myArmy.addUnits(3, ::Knight)


  val enemyArmy = Army()
  enemyArmy.addUnits(3, ::Warrior)

  val army3 = Army()
  army3.addUnits(20, ::Warrior)
  army3.addUnits(5, ::Knight)

  val army4 = Army()
  army4.addUnits(30, ::Knight)

  check(fight(myArmy, enemyArmy) == true)
  check(fight(army3, army4) == false)
  println("TWO OK")

 }
    
    fun smokeTestDefender() {
        val chuck = Warrior()
        val bruce = Warrior()
        val carl = Knight()
        val dave = Warrior()
        val mark = Warrior()
        val bob = Defender()
        val mike = Knight()
        val rog = Warrior()
        val lancelot = Defender()

        assert(fight(chuck, bruce) == true)
        assert(fight(dave, carl) == false)
        assert(chuck.isAlive == true)
        assert(bruce.isAlive == false)
        assert(carl.isAlive == true)
        assert(dave.isAlive == false)
        assert(fight(carl, mark) == false)
        assert(carl.isAlive == false)
        assert(fight(bob, mike) == false)
        assert(fight(lancelot, rog) == true)

        val myArmy = Army()
        myArmy.addUnits(1, ::Defender)

        val enemyArmy = Army()
        enemyArmy.addUnits(2, ::Warrior)

        val army3 = Army()
        army3.addUnits(1, ::Warrior)
        army3.addUnits(1, ::Defender)

        val army4 = Army()
        army4.addUnits(2, ::Warrior)

        assert(fight(myArmy, enemyArmy) == false)
        assert(fight(army3, army4) == true)
        println("DEFENDERS OK")
    }

    fun smokeTestVampires(){
        val chuck = Warrior()
        val bruce = Warrior()
        val carl = Knight()
        val dave = Warrior()
        val mark = Warrior()
        val bob = Defender()
        val mike = Knight()
        val rog = Warrior()
        val lancelot = Defender()
        val eric = Vampire()
        val adam = Vampire()
        val richard = Defender()
        val ogre = Warrior()

        assert(fight(chuck, bruce) == true)
        assert(fight(dave, carl) == false)
        assert(chuck.isAlive == true)
        assert(bruce.isAlive == false)
        assert(carl.isAlive == true)
        assert(dave.isAlive == false)
        assert(fight(carl, mark) == false)
        assert(carl.isAlive == false)
        assert(fight(bob, mike) == false)
        assert(fight(lancelot, rog) == true)
        assert(fight(eric, richard) == false)
        assert(fight(ogre, adam) == true)

        val myArmy = Army()
        myArmy.addUnits(2, ::Defender)
        myArmy.addUnits(2, ::Vampire)
        myArmy.addUnits(1, ::Warrior)

        val enemyArmy = Army()
        enemyArmy.addUnits(2, ::Warrior)
        enemyArmy.addUnits(2, ::Defender)
        enemyArmy.addUnits(3, ::Vampire)

        val army3 = Army()
        army3.addUnits(1, ::Warrior)
        army3.addUnits(4, ::Defender)

        val army4 = Army()
        army4.addUnits(3, ::Vampire)
        army4.addUnits(2, ::Warrior)

        assert(fight(myArmy, enemyArmy) == false)
        assert(fight(army3, army4) == true)
        println("VAMPIRES OK")
    }


    smokeTestOne()
   smokeTestTwo()
    smokeTestDefender()
   smokeTestVampires()
}

