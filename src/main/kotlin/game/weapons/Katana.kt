package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Params

class Katana(
    private val health: Int = Params.Katana.HEALTH,
    private val attack: Int = Params.Katana.ATTACK,
    private val defence: Int = Params.Katana.DEFENCE,
    private val vampirism: Int = Params.Katana.VAMPIRISM,
) : WeaponDecorator(health, attack, defence, vampirism) {
     override val getDefence: Int
        get() = this.defence
     override val getVampirism: Int
        get() = this.vampirism
}