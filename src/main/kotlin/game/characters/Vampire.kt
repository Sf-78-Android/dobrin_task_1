package game.characters

import game.settings.Params

class Vampire : Warrior(Params.Vampire.HEALTH) {
    override val attack: Int = Params.Vampire.ATTACK
    val vampirism: Int = Params.Vampire.VAMPIRISM


    override fun hit(opponent: Warrior) {
        val healthBefore = opponent.health
        super.hit(opponent)
        val damageDealt = healthBefore-opponent.health
        val healPoints = (damageDealt*vampirism) / 100
        heal(healPoints)
    }

}