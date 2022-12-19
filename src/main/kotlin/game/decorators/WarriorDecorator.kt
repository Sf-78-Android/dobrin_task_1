package game.decorators

import game.enums.FightType
import game.interfaces.BaseWarrior
import game.weapons.Weapon


abstract class WarriorDecorator(private val warrior: BaseWarrior) : BaseWarrior {

    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        warrior.hit(opponent, fightType)
    }

    override fun receiveDamage(damage: Int) {
        warrior.receiveDamage(damage)
    }

    override fun restoreHp(amountHp: Int) {
        warrior.restoreHp(amountHp)
    }


    abstract override val isAlive: Boolean

    override var warriorBehind: BaseWarrior? = null

 //  override var weapon: Weapon? = null

  //  abstract override fun equipWeapon(weapon: Weapon)

}