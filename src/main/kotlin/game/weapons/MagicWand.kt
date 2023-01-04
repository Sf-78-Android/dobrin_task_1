package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class MagicWand(
    private val health: Int = Params.MagicWand.HEALTH,
    private val attack: Int = Params.MagicWand.ATTACK,
    private val healingPower: Int = Params.MagicWand.HEALING_POWER
) : WeaponDecorator() {

    override fun getHealth(): Int {
        return this.health
    }

    override fun getAttack(): Int {
        return this.attack
    }

    override fun getHealingPower(): Int {
        return this.healingPower
    }

    override fun getDefence(): Int {
        return 0
    }

    override fun getVampirism(): Int {
        return 0
    }
}