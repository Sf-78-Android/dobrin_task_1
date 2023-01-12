package game.decorators

import game.interfaces.BaseWeapon
import game.settings.Constants

abstract class WeaponDecorator: BaseWeapon {

    override fun getHealth(): Int {
        return  Constants.ZERO
    }

    override fun getAttack(): Int {
        return  Constants.ZERO
    }

    override fun getDefence(): Int {
        return Constants.ZERO
    }

    override fun getVampirism(): Int {
        return  Constants.ZERO
    }

    override fun getHealingPower(): Int {
        return  Constants.ZERO
    }
}