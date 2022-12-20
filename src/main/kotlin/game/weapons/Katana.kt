package game.weapons

import game.settings.Params

class Katana(
    health: Int = Params.Katana.HEALTH,
    attack: Int = Params.Katana.ATTACK,
    defence: Int = Params.Katana.DEFENCE,
    vampirism: Int = Params.Katana.VAMPIRISM,
    healingPower: Int = Params.Katana.HEALING_POWER
) : Weapon(health, attack, defence, vampirism, healingPower)