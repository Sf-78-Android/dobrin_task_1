package game.testInteractions

import game.testCollections.TestArmy
import game.interfaces.BaseWarrior

 object TestBattle  {

     fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender)
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }


     fun fight(army1: TestArmy, army2: TestArmy): Boolean {
        while (army1.hasTroopsLeft && army2.hasTroopsLeft) {
            val warrior1 = army1.nextWarrior()
            val warrior2 = army2.nextWarrior()
                if (fight(warrior1, warrior2)) {
                    army2.killedWarrior()
                } else {
                    army1.killedWarrior()
            }
        }
        return army1.hasTroopsLeft
    }
}

