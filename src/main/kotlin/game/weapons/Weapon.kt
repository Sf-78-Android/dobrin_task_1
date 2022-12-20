package game.weapons

import game.decorators.WeaponDecorator

class Weapon(health: Int, attack : Int) :WeaponDecorator(health, attack) {
    constructor(health: Int, attack: Int, defence : Int) : this(health, attack)
    constructor(health: Int, attack: Int, defence : Int, vampirism: Int) : this(health, attack)
    constructor(health: Int, attack: Int, defence : Int, vampirism: Int, healingPower:Int) : this(health, attack)

}

