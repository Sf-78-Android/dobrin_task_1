package game.interfaces

import game.characters.Warrior

interface Hittable {
    fun hit(opponent: Warrior)
}