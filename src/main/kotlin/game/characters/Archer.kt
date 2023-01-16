package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.interfaces.CanShoot
import game.settings.Constants
import game.settings.Params
import log.constants.MsgTemplate.archerHitsWarlord

class Archer : WarriorDecorator(), CanShoot {

    private var initialHealth = Params.Archer.HEALTH
    private var health: Int = Params.Archer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(Constants.ZERO)
        }
    private var attack: Int = Params.Archer.ATTACK
        private set(value) {
            field = value.coerceAtLeast(Constants.ZERO)
        }


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        if (fightType == FightType.Classic)
            opponent.receiveDamage(this.attack/Constants.TWO)
    }



    override fun receiveDamage(damage: Int) {
       this.health-=damage
    }

    override fun restoreHp(amountHp: Int) {
        this.health+=amountHp
    }

    override val getHealth: Int
        get() = this.health
    override val getAttack: Int
        get() = this.attack

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        this.initialHealth+=weapon.getHealth()
        this.health=initialHealth
        this.attack+=weapon.getAttack()
        this.equippedWeapon(weapon)
    }

    override fun shoot(target: BaseWarrior) {
        if (target is Warlord){
            val tripleDamage = this.attack*Constants.THREE
            target.receiveDamage(tripleDamage)
            Battle.getLog().logMessage(String.format(archerHitsWarlord,this.javaClass.simpleName,target.javaClass.simpleName, tripleDamage))
        } else {
            target.receiveDamage(this.attack)
        }
    }
}