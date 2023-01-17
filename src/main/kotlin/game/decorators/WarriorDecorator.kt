package game.decorators

import game.collections.Weapons
import game.enums.FightType
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.weapons.Weapon
import log.constants.MsgTemplate.warriorHitMsg
import log.constants.MsgTemplate.weaponEquipMsg


abstract class WarriorDecorator : BaseWarrior {


    override fun hit(opponent: BaseWarrior, fightType : FightType) {
        opponent.receiveDamage(this.getAttack)
        Battle.getLog().logMessage(String.format(warriorHitMsg, this.javaClass.simpleName, opponent.javaClass.simpleName, this.getAttack, opponent.getHealth))
    }


    abstract override fun receiveDamage(damage: Int)

   abstract  override fun restoreHp(amountHp: Int)


    override val isAlive: Boolean
        get() = this.getHealth > 0

    override var warriorBehind: BaseWarrior? = null


    override var warriorIfFront: BaseWarrior? = null

    override var weapons: Weapons = Weapons()

    fun equippedWeapon(weapon: BaseWeapon) {
        Battle.getLog().logMessage(String.format(weaponEquipMsg,this.javaClass.simpleName,weapon.toString()))
    }

}