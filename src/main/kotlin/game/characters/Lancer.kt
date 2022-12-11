package game.characters

import game.settings.Params

class Lancer : Warrior(Params.Lancer.HEALTH) {
    override val attack: Int = Params.Lancer.ATTACK
    val pierce = Params.Lancer.PIERCING_POWER

    override fun hit(opponent: Warrior) {
        val healthBefore = opponent.health
        super.hit(opponent)
        val damageDealt = healthBefore-opponent.health
        val damageToNext : Int = (damageDealt*pierce)/100
        // opponent.warriorBehind?.receiveDamage(damageToNext)
        super.hit(opponent.warriorBehind, damageToNext)

    }
}


