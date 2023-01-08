package game.decorators

import game.interfaces.BaseWeapon

abstract class WeaponDecorator: BaseWeapon {

    override fun getHealth(): Int {
        return  0
    }

    override fun getAttack(): Int {
        return  0
    }

    override fun getDefence(): Int {
        return 0
    }

    override fun getVampirism(): Int {
        return  0
    }

    override fun getHealingPower(): Int {
        return  0
    }
}