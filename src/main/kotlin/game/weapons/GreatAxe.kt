package game.weapons

import game.settings.Params

class GreatAxe(
      health: Int = Params.GreatAxe.HEALTH,
      attack: Int = Params.GreatAxe.ATTACK,
      defence: Int = Params.GreatAxe.DEFENCE,
      vampirism: Int = Params.GreatAxe.VAMPIRISM,
      healingPower: Int = Params.GreatAxe.HEALING_POWER
) : Weapon(health, attack,defence,vampirism,healingPower)