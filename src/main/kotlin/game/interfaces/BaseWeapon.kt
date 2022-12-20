package game.interfaces

import game.weapons.Weapon

interface BaseWeapon {
    fun equipWeapon(weapon: Weapon)
}