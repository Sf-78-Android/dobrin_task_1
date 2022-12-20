package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.BaseWeapon
import game.settings.Params
import game.weapons.Weapon


class Knight : WarriorDecorator() {
    private var initialHealth = Params.Knight.HEALTH
    private var health: Int = Params.Knight.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private var attack: Int = Params.Knight.ATTACK


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack



    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth+= weapon.getHealth
        attack+=weapon.getAttack

    }

    override fun toString(): String {
        return """Knight
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
     """
    }
}