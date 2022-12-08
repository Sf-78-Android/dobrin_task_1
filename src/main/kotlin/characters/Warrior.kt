package characters

import interfaces.Hittable


open class Warrior(health : Int = 50) : Hittable {
   override fun hit(opponent: Warrior) {
        opponent.health-= attack
    }
    override fun hit(opponent: Defender) {
        opponent.health-= attack-opponent.defence
    }

   var health: Int = health
    open val attack: Int = 5
    val isAlive: Boolean
    get() = health > 0

}

