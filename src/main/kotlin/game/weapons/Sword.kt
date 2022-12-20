package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class Sword(
    health: Int = Params.Sword.HEALTH,
    attack: Int = Params.Sword.ATTACK,

) : WeaponDecorator(health, attack)