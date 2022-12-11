package game.characters

import game.interfaces.Damagable
import game.interfaces.Hittable
import game.settings.Params


open class Warrior(health: Int = Params.Warrior.HEALTH) : Hittable, Damagable {
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

      override fun receiveDamage(damage: Int) {
        health-=damage
    }

    protected fun heal(amount: Int) {
        health+=amount
    }

    protected fun hit(opponent: Warrior?, damageToNext: Int) {
        opponent?.health = opponent?.health?.minus(damageToNext)!!
    }

    internal var warriorBehind: Warrior? = null
}

