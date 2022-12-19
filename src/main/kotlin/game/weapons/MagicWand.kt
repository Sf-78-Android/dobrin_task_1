package game.weapons

import game.settings.Params

class MagicWand(
    override val health: Int= Params.MagicWand.HEALTH,
    override val attack: Int = Params.MagicWand.ATTACK,
    override val defence: Int = 0,
    override val vampirism: Int = 0,
    override val healingPower: Int = Params.MagicWand.HEAL_POWER
) :Weapon()