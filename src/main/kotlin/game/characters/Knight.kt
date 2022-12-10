package game.characters

import game.settings.Params


class Knight : Warrior(Params.Knight.HEALTH) {

    override val attack: Int = Params.Knight.ATTACK
}