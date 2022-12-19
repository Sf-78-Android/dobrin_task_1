package game.weapons

import game.settings.Params

class Sword(
    override val health: Int = Params.Sword.HEALTH,
    override val attack: Int  = Params.Sword.ATTACK,
    override val defence: Int = 0 ,
    override val vampirism: Int  =0 ,
    override val healingPower: Int  =0
) : Weapon()