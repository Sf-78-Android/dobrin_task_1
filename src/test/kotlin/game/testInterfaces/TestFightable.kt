package game.testInterfaces

import game.collections.Army
import game.interfaces.BaseWarrior
import game.testCollections.TestArmy

interface TestFightable {
    fun fight(army1: TestArmy, army2: TestArmy): Boolean
    fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean
    fun straightFight(army1: TestArmy,army2: TestArmy) : Boolean
    fun straightFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean

}