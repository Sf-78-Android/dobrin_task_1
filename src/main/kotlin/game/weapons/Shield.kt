package game.weapons

import game.settings.Params

class Shield(
    override val health: Int = Params.Shield.HEALTH,
    override val attack: Int = Params.Shield.ATTACK,
    override val defence: Int = Params.Shield.DEFENCE,
    override val vampirism: Int= 0,
    override val healingPower: Int = 0
) : Weapon()