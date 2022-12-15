package game.interactions

import game.collections.Army
import game.interfaces.BaseWarrior
import game.interfaces.Fightable

object Battle : Fightable {

    override fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender)
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }


    override fun fight(army1: Army, army2: Army): Boolean {
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

