package game.interactions

import game.characters.Healer
import game.collections.Army
import game.interfaces.BaseWarrior
import game.interfaces.Fightable

object Battle : Fightable {

    override fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender)

            if (defender.warriorBehind is Healer){
                defender.restoreHp((defender.warriorBehind as Healer).healingPower)
            }
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }

    override fun straightFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender)
            // TODO implement another hit type
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }

    override fun straightFight(army1: Army, army2: Army): Boolean {
       while (army1.hasTroopsLeft && army2.hasTroopsLeft) {
           val size = when {
               army1.size < army2.size -> army1.size
               army1.size > army2.size -> army2.size
               else -> {
                   army1.size
               }
           }
           for (i in 0..size) {
               if (fight(army1.getWarriorAtPosition(i), army2.getWarriorAtPosition(i))) {
                   army2.killedWarrior(i)
               } else {
                   army1.killedWarrior(i)
               }
           }
       }

        return army1.hasTroopsLeft
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

