package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Constants
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
        return Constants.ZERO
    }

    override fun getVampirism(): Int {
        return Constants.ZERO
    }

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}