package game.characters

import game.interfaces.Hittable
import game.settings.Params


open class Warrior(health: Int = Params.Warrior.HEALTH) : Hittable {
   private val initialHealth = health
    var health = health
    private set(value) {
        field = value.coerceAtMost(initialHealth)
    }
    open val attack: Int = Params.Warrior.ATTACK
    val isAlive: Boolean
        get() = health > 0

    override fun hit(opponent: Warrior) {
       opponent.receiveDamage(attack)
    }

     internal open fun receiveDamage(damage: Int) {
        health-=damage
    }

    protected fun heal(amount: Int) {
        health+=amount
    }

    // TODO get the warrior behind

    internal var warriorBehind: Warrior? = null
}

