package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Constants
import game.settings.Params

class GreatAxe(
    private val health: Int = Params.GreatAxe.HEALTH,
    private val attack: Int = Params.GreatAxe.ATTACK,
    private val defence: Int = Params.GreatAxe.DEFENCE,
    private val vampirism: Int = Params.GreatAxe.VAMPIRISM,

    ) : WeaponDecorator() {

    override fun getHealth(): Int {
        return this.health
    }

    override fun getAttack(): Int {
        return this.attack
    }

    override fun getDefence(): Int {
        return this.defence
    }

    override fun getVampirism(): Int {
        return this.vampirism
    }

    override fun getHealingPower(): Int {
        return Constants.ZERO
    }

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}