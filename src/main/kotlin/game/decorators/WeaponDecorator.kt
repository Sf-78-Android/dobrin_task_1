package game.decorators

import game.interfaces.BaseWeapon

abstract class WeaponDecorator(private val health: Int, private  val attack: Int): BaseWeapon {
    constructor(health: Int, attack: Int, defence: Int, vampirism: Int) : this(health, attack)
    constructor(health: Int, attack: Int, defence: Int, vampirism: Int, healingPower: Int) : this(health, attack)
    constructor(health: Int, attack: Int, healingPower: Int) : this(health, attack)


    override val getAttack: Int
        get() = attack
    override val getHealth: Int
        get() = health
    override val getDefence: Int
        get() = 0
    override val getVampirism: Int
        get() = 0
    override val getHealingPower: Int
        get() = 0
}