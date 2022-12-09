package interfaces

import characters.Warrior

interface Hittable {
    fun hit (opponent: Warrior)
    fun hitAndPierce(opponent: Warrior,nextOpponent:Warrior)

}