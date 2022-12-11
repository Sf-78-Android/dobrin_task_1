package game.testClass

import game.characters.Warrior
import game.settings.Params

class Rookie : Warrior(health = 3) {
    override val attack: Int = 1
}