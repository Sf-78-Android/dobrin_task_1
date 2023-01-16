package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class Shield(
    private val health: Int = Params.Shield.HEALTH,
    private val attack: Int = Params.Shield.ATTACK,
    private val defence: Int = Params.Shield.DEFENCE,

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

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}