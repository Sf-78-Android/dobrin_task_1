package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class MagicWand(
    health: Int = Params.MagicWand.HEALTH,
    attack: Int = Params.MagicWand.ATTACK,

    private val healingPower: Int = Params.MagicWand.HEALING_POWER
) : WeaponDecorator(health, attack, healingPower) {
     override val getHealingPower: Int
        get() = this.healingPower
}