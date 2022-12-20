package game.weapons

import game.settings.Params

class Shield(
    health: Int = Params.Shield.HEALTH,
    attack: Int = Params.Shield.ATTACK,
    defence: Int = Params.Shield.DEFENCE,
    vampirism: Int = Params.Shield.VAMPIRISM,
    healingPower: Int = Params.Shield.HEALING_POWER
) : Weapon(health,attack,defence,vampirism,healingPower)