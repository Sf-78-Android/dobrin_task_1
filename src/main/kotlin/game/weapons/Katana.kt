package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Constants
import game.settings.Params

class Katana(
    private val health: Int = Params.Katana.HEALTH,
    private val attack: Int = Params.Katana.ATTACK,
    private val defence: Int = Params.Katana.DEFENCE,
    private val vampirism: Int = Params.Katana.VAMPIRISM,
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
}