package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.CanHeal
import game.settings.Params
import game.weapons.Weapon

class Healer : WarriorDecorator() , CanHeal {
    private var initialHealth = Params.Defender.HEALTH
    private var health: Int = Params.Healer.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private var attack: Int = Params.Healer.ATTACK
    private var healingPower: Int = Params.Healer.HEALING_POWER


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    private val getHealingPower: Int
        get() = healingPower

    override val isAlive: Boolean
        get() = health > 0


    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: Weapon) {
        weapons.addWeapon(weapon)
        initialHealth+= weapon.getHealth
        attack+=weapon.getAttack
        healingPower+=weapon.getHealingPower
    }

    override fun heal(allyInFront: BaseWarrior, fightType: FightType) {
        if (fightType == FightType.Classic){
            allyInFront.restoreHp(healingPower)
        }
    }



    override fun toString(): String {
        return """Healer
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Healing power = ${this.getHealingPower}"""
    }
}