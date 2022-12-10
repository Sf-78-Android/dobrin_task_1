package game.interfaces

import game.characters.Warrior

interface Pierce {
    fun hitAndPierce(opponent: Warrior, nextOpponent: Warrior)
}