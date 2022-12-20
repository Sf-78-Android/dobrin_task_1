package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class Shield(
    health: Int = Params.Shield.HEALTH,
    attack: Int = Params.Shield.ATTACK,
    private val defence: Int = Params.Shield.DEFENCE,

) : WeaponDecorator(health,attack,defence){
    override val getDefence: Int
        get() = this.defence
}