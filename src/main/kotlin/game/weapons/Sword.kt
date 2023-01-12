package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class Sword(
    private val health: Int = Params.Sword.HEALTH,
    private val attack: Int = Params.Sword.ATTACK,

    ) : WeaponDecorator() {

    override fun getHealth(): Int {
        return this.health
    }

    override fun getAttack(): Int {
        return this.attack
    }
}