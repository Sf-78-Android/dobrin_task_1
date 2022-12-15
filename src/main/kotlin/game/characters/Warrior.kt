package game.characters


import game.interfaces.BaseWarrior
import game.settings.Params


class Warrior() : BaseWarrior {
    private val attack: Int = Params.Warrior.ATTACK
    private var health: Int = Params.Warrior.HEALTH
    override val isAlive: Boolean
        get() = health > 0

    override fun hit(opponent: BaseWarrior) {
       opponent.receiveDamage(attack)
    }

      override fun receiveDamage(damage: Int) {
        health-=damage
    }

    override var warriorBehind: BaseWarrior? = null

    override val getHealth: Int
        get() = health

}

