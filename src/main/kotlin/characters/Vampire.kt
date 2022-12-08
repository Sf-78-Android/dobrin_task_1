package characters

class Vampire: Warrior (health = 40) {
    override val attack: Int = 4
    val vampirism: Int = 50

    override fun hit(opponent: Warrior) {
        opponent.health -= attack
        health+= attack*vampirism/100
    }

    override fun hit(opponent: Defender) {
        opponent.health -= attack-opponent.defence
        health+= (attack-opponent.defence)*vampirism/100
    }
}