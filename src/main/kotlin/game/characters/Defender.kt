package game.characters

import game.decorators.WarriorDecorator
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.settings.Params
import game.weapons.Weapon

class Defender (val warrior: Warrior) : WarriorDecorator(warrior) {
    private val initialHealth = Params.Defender.HEALTH
    private var health : Int = Params.Defender.HEALTH
        private set(value) {
            field =value.coerceAtMost(initialHealth)
        }
     private val attack: Int = Params.Defender.ATTACK
     private val defence: Int
     get()= Params.Defender.DEFENCE
    private val vampirism : Int = 0
    private val healingPower: Int = 0

    override fun hit(opponent: BaseWarrior, fightType: FightType) {
        opponent.receiveDamage(attack)
    }

    override fun receiveDamage(damage: Int) {
        health-= (damage-defence).coerceAtLeast(0)
    }


    override var warriorBehind: BaseWarrior? = null

    override var weapon: Weapon? = null


    // TODO continue
    override fun equipWeapon(weapon: Weapon) {
        this.weapon=weapon
    }

    override val isAlive: Boolean
        get() = health>0

    override fun restoreHp(amountHp: Int) {
       health+=amountHp
    }


    override val getHealth: Int
        get() = health


}