package game.decorators

import game.collections.Weapons
import game.enums.FightType
import game.interfaces.BaseWarrior


abstract class WarriorDecorator : BaseWarrior {

    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        opponent.receiveDamage(this.getAttack)
    }


    abstract override fun receiveDamage(damage: Int)

    abstract override fun restoreHp(amountHp: Int)


    override val isAlive: Boolean
        get() = this.getHealth > 0

    override var warriorBehind: BaseWarrior? = null

    //  get() = if (field?.isAlive ?: true) field else (field as? BaseWarrior)
    override var warriorIfFront: BaseWarrior? = null

    override var weapons: Weapons = Weapons()


}