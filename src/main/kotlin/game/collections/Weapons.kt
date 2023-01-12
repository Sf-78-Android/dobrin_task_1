package game.collections

import game.interfaces.BaseWeapon

class Weapons {
    private val weapons = mutableListOf<BaseWeapon>()

    fun addWeapon(weapon: BaseWeapon) {
        weapons.add(weapon)
    }

}