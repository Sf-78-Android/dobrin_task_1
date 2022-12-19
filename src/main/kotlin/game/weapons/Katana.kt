package game.weapons

import game.settings.Params

class Katana(
    override val health: Int= Params.Katana.HEALTH,
    override val attack: Int =  Params.Katana.ATTACK,
    override val defence: Int = Params.Katana.DEFENCE,
    override val vampirism: Int = Params.Katana.VAMPIRISM,
    override val healingPower: Int = 0
) : Weapon()