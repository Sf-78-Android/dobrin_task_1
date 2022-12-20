package game.decorators

import game.enums.FightType
import game.interfaces.BaseWarrior


abstract class WarriorDecorator : BaseWarrior {

    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage((this.getAttack - opponent.getDefence).coerceAtLeast(0))
        val damageDealt = healthBefore - opponent.getHealth
        val healPoints = (damageDealt * this.getVampirism) / 100
        restoreHp(healPoints)
    }


    abstract override fun receiveDamage(damage: Int)

    abstract override fun restoreHp(amountHp: Int)

    override fun heal(allyInFront: BaseWarrior, fightType: FightType) {
        if (fightType == FightType.Classic) {
            allyInFront.restoreHp(this.getHealingPower)
        }
    }

    override fun heal(allyInFront: BaseWarrior) {
        allyInFront.restoreHp(this.getHealingPower)
    }

    override fun toString(): String {
        return "Warrior Type = Vampire" +
                "Health = ${this.getHealth}\n" +
                "Attack = ${this.getAttack}\n" +
                "Defence = ${this.getDefence}\n" +
                "Vampirism = ${this.getVampirism}\n" +
                "Healing power = ${this.getHealingPower}\n"
    }


    override val isAlive: Boolean
        get() = this.getHealth > 0

    override var warriorBehind: BaseWarrior? = null


    //  override var weapon: Weapon? = null

    //  abstract override fun equipWeapon(weapon: Weapon)

}