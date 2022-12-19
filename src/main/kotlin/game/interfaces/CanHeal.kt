package game.interfaces

import game.enums.FightType

interface CanHeal {
    fun heal(allyInFront: BaseWarrior, fightType: FightType)
}