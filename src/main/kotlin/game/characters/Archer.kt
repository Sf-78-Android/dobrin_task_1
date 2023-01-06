package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.interfaces.CanShoot
import game.settings.Params

class Archer : WarriorDecorator(), CanShoot {

    private var initialHealth = Params.Archer.HEALTH
    private var health: Int = Params.Archer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(0)
        }
    private var attack: Int = Params.Archer.ATTACK
        private set(value) {
            field = value.coerceAtLeast(0)
        }


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        if (fightType == FightType.Classic){
            opponent.receiveDamage(this.attack/2)
        }
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
    }

    override fun shoot(target: BaseWarrior) {
        if (target is Warlord){
            target.receiveDamage(this.attack*3)
        } else {
            target.receiveDamage(this.attack)
        }
    }
}