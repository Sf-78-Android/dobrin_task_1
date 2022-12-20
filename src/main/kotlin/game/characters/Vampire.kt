package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.settings.Params
import game.weapons.Weapon

class Vampire : WarriorDecorator() {
    private var initialHealth = Params.Vampire.HEALTH
    private var health = initialHealth
        private set(value) {
            field = value.coerceAtMost(initialHealth)
        }
    private var attack: Int = Params.Vampire.ATTACK
    private var vampirism: Int = Params.Vampire.VAMPIRISM


    override val getHealth: Int
        get() = health
    override val getAttack: Int
        get() = attack
    private val getVampirism: Int
        get() = vampirism


    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        val healthBefore = opponent.getHealth
        opponent.receiveDamage(attack)
        val damageDealt = healthBefore - opponent.getHealth
        val healPoints = (damageDealt * vampirism) / 100
        restoreHp(healPoints)
    }

    override fun receiveDamage(damage: Int) {
        health -= damage
    }

    override fun restoreHp(amountHp: Int) {
        health += amountHp
    }

    override fun equipWeapon(weapon: Weapon) {
        weapons.addWeapon(weapon)
        initialHealth += weapon.getHealth
        attack += weapon.getAttack
        vampirism += weapon.getVampirism

    }


    override fun toString(): String {
        return """Vampire
      Health = ${this.getHealth}
      Attack = ${this.getAttack}
      Vampirism = ${this.getVampirism}
     """
    }
}