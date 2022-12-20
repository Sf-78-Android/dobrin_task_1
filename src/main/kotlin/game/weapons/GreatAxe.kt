package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class GreatAxe(
    private val health: Int = Params.GreatAxe.HEALTH,
    private val attack: Int = Params.GreatAxe.ATTACK,
    private val defence: Int = Params.GreatAxe.DEFENCE,
    private val vampirism: Int = Params.GreatAxe.VAMPIRISM,
) : WeaponDecorator(health, attack, defence, vampirism) {


    override val getDefence: Int
        get() = this.defence
   override val getVampirism: Int
        get() = this.vampirism
}