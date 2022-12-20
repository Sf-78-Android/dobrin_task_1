package game.weapons

import game.settings.Params

class Sword(
    health: Int = Params.Sword.HEALTH,
    attack: Int = Params.Sword.ATTACK,
    defence: Int = Params.Sword.DEFENCE,
    vampirism: Int = Params.Sword.VAMPIRISM,
    healingPower: Int = Params.Sword.HEALING_POWER
) : Weapon(health, attack, defence, vampirism, healingPower)