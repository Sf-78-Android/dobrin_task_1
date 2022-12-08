package interfaces

import characters.Defender
import characters.Warrior

interface Hittable {
    fun hit (opponent: Warrior)
    fun hit(opponent: Defender)

}