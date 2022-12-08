package characters

import interfaces.Hittable


open class Warrior(health : Int = 50) : Hittable {

   override fun hit(opponent: Warrior) {
       when(true){
           (opponent is Defender && this !is Vampire) ->  opponent.health-= attack-opponent.defence
           (this is Vampire) -> {
               if (opponent is Defender) {
                   opponent.health -= attack-opponent.defence
                   health+= (attack-opponent.defence)*vampirism/100
               } else {
                   opponent.health -= attack
                   health+= attack*vampirism/100
               }
           }
           else ->  opponent.health-= attack
       }
    }

    var health: Int = health
    private  set
    open val attack: Int = 5
    val isAlive: Boolean
    get() = health > 0

}

