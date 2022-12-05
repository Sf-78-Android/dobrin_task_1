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

class Knight : Warrior(50){
    override val attack: Int = 8
}

class Army {
    private val troops = arrayListOf<Warrior>()
    fun addUnits(quantity: Int, factory: () -> Warrior) {
       repeat(quantity) {
           val warrior1 = factory()
           troops.add(warrior1)
       }
   }
    fun nextWarrior(): Warrior { return troops.first()}
    fun killedWarrior() {
        troops.removeFirst();
    }
    val hasTroopsLeft: Boolean
    get() = troops.size > 0

}

fun fight(warrior1: Warrior, warrior2: Warrior) : Boolean {
    var attacker= warrior1
    var defender = warrior2
    while (attacker.isAlive){
        attacker.hit(defender)
        attacker = defender.also { defender = attacker }
    }
    return warrior1.isAlive
}

fun fight(army1: Army, army2: Army) :Boolean {
    while (army1.hasTroopsLeft && army2.hasTroopsLeft){
        val warrior1 = army1.nextWarrior()
        val warrior2 = army2.nextWarrior()
        if(fight(warrior1,warrior2) ){
            army2.killedWarrior()
        } else{
            army1.killedWarrior()
        }
    }
    return army1.hasTroopsLeft
}
/*

fun main(){
    // smoke test
    val chuck = Warrior()
    val bruce = Warrior()

    check(fight(chuck,bruce) == true) {"Warrior should win Warrior"}
    check(chuck.isAlive == true) {"Warrior winner should be alive "}
    check(bruce.isAlive == false) {"Warrior winner should not be alive "}
    val carl = Knight()
    val dave = Warrior()
    check(fight(dave,carl) == false) {"Warrior should lose to Knight"}
    check(carl.isAlive == true) {"Knight winner should be alive "}
    check(dave.isAlive == false) {"Warrior defeated should not be alive "}
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

        check(fight(myArmy, enemyArmy) == true)
        check(fight(army3, army4) == false)
        println("OK")

}