package characters

import collections.Army
import interactions.Battle


open class Warrior(health : Int = 50) {
    fun hit(opponent: Warrior) {
        opponent.health-= attack
    }
    var health: Int = health
       private set
    open val attack: Int = 5
    val isAlive: Boolean
    get() = health > 0


}






/*

fun entities.main(){
    // smoke test
    val chuck = entities.Warrior()
    val bruce = entities.Warrior()

    check(entities.fight(chuck,bruce) == true) {"entities.Warrior should win entities.Warrior"}
    check(chuck.isAlive == true) {"entities.Warrior winner should be alive "}
    check(bruce.isAlive == false) {"entities.Warrior winner should not be alive "}
    val carl = entities.Knight()
    val dave = entities.Warrior()
    check(entities.fight(dave,carl) == false) {"entities.Warrior should lose to entities.Knight"}
    check(carl.isAlive == true) {"entities.Knight winner should be alive "}
    check(dave.isAlive == false) {"entities.Warrior defeated should not be alive "}
    println("OK")
}

 */
fun main() {


        val myArmy = Army()
        myArmy.addUnits(3, ::Knight)


        val enemyArmy = Army()
        enemyArmy.addUnits(3, ::Warrior)

        val army3 = Army()
        army3.addUnits(20, ::Warrior)
        army3.addUnits(5, ::Knight)

        val army4 = Army()
        army4.addUnits(30, ::Knight)

        check(Battle().fight(myArmy, enemyArmy) == true)
        check(Battle().fight(army3, army4) == false)
        println("OK")

}