package game.weapons

import game.settings.Params

class GreatAxe(
    override val health: Int = Params.GreatAxe.HEALTH,
    override val attack: Int = Params.GreatAxe.ATTACK,
    override val defence: Int = Params.GreatAxe.DEFENCE,
    override val vampirism: Int = Params.GreatAxe.VAMPIRISM,
    override val healingPower: Int = 0
) : Weapon()