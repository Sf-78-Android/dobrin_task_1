package game.weapons

import game.settings.Params

class MagicWand(
    health: Int = Params.MagicWand.HEALTH,
    attack: Int = Params.MagicWand.ATTACK,
    defence: Int = 0,
    vampirism: Int = 0,
    healingPower: Int = Params.MagicWand.HEALING_POWER
) : Weapon(health, attack, defence, vampirism, healingPower)