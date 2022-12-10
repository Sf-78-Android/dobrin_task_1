package game.testClass

import game.characters.Warrior
import game.settings.Params

class Rookie : Warrior(Params.Defender.HEALTH) {
    override val attack: Int = 1
}