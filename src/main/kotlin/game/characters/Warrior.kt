package game.characters


import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.settings.Params
import game.weapons.Weapon

class Warrior : WarriorDecorator() {
    private var initialHealth = Params.Warrior.HEALTH
    private var attack: Int = Params.Warrior.ATTACK
    private var health: Int = Params.Warrior.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }


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


    override fun equipWeapon(weapon: Weapon) {
        weapons.addWeapon(weapon)
        initialHealth+= weapon.getHealth
        attack+=weapon.getAttack

    }

    override fun toString(): String {
        return """Warrior
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
     """
    }

}

