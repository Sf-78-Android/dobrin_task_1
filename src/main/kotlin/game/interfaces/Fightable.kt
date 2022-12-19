package game.interfaces

import game.collections.Army

interface Fightable {
    fun fight(army1: Army, army2: Army): Boolean
    fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean
    fun straightFight(army1: Army,army2: Army) : Boolean
    fun straightFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean

}