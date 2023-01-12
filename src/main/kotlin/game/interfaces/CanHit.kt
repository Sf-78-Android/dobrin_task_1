package game.interfaces

import game.enums.FightType

interface CanHit {
    fun hit(opponent : BaseWarrior, fightType: FightType)
}