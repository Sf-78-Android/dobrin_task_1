package characters

import interfaces.Hittable


open class Warrior(health: Int = 50) : Hittable {

    override fun hit(opponent: Warrior) {
        val damage: Int = if (opponent is Defender) {
            attack - opponent.defence
        } else {
            attack
        }

        when (true) {
            (opponent is Defender && this !is Vampire) -> {
                if (damage > 0) {
                    opponent.health -= damage
                }
            }
            (this is Vampire) -> {
                if (opponent is Defender) {
                    opponent.health -= damage
                    health += damage * vampirism / 100
                } else {
                    opponent.health -= damage
                    health += damage * vampirism / 100
                }
            }
            else -> opponent.health -= damage
        }
    }

    var health: Int = health
        private set
    open val attack: Int = 5
    val isAlive: Boolean
        get() = health > 0

}

