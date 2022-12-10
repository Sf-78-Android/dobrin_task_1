package game.characters

import game.settings.Params

class Defender: Warrior(Params.Defender.HEALTH) {
    override val attack: Int = Params.Defender.ATTACK
     val defence: Int
     get()= Params.Defender.DEFENCE

    override fun receiveDamage(damage: Int) {
        super.receiveDamage(
            (damage-defence).coerceAtLeast(0)
        )
    }
}