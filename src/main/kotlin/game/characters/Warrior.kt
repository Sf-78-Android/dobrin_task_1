package game.characters


import game.decorators.WarriorDecorator
import game.interfaces.BaseWeapon
import game.settings.Params

class Warrior : WarriorDecorator() {
    private var initialHealth = Params.Warrior.HEALTH
    private var attack: Int = Params.Warrior.ATTACK
        private set(value) {
            field = value.coerceAtLeast(0)
        }
    private var health: Int = Params.Warrior.HEALTH
        private set(value) {
            field = value.coerceAtMost(initialHealth).coerceAtLeast(0)
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


    override fun equipWeapon(weapon: BaseWeapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth()
        health = initialHealth
        attack += weapon.getAttack()

    }

    override fun toString(): String {
        return """Warrior
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
     """
    }

}

