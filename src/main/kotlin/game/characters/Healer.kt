package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.CanHeal
import game.settings.Params

class Healer (val warrior: BaseWarrior) : WarriorDecorator(warrior), CanHeal {
    private val initialHealth = Params.Defender.HEALTH
    private var health : Int = Params.Healer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private val attack : Int = Params.Healer.ATTACK
       val healingPower : Int
         get() = Params.Healer.healingPower

    override val isAlive: Boolean
        get() = health > 0

    override fun hit(opponent: BaseWarrior,fightType: FightType) {
        opponent.receiveDamage(attack)
    }

    override val getHealth: Int
        get() = health

    override fun heal(allyInFront: BaseWarrior, fightType: FightType) {
        if (fightType == FightType.Classic) {
            allyInFront.restoreHp(healingPower)
        }
    }

    override fun receiveDamage(damage: Int) {
        health-=damage
    }

    override fun restoreHp(amountHp: Int) {
        health+=amountHp
    }

    override var warriorBehind: BaseWarrior? = null

}