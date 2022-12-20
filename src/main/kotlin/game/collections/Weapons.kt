package game.collections

import game.weapons.Weapon

class Weapons {
    private val weapons = mutableListOf<Weapon>()

    fun equipWeapon(weapon: Weapon) {
        weapons.add(weapon)
    }
    val getWeapons : MutableList<Weapon>
        get() = weapons


}