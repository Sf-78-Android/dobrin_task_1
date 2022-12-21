package game.testInteractions

import game.characters.Healer
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.testCollections.TestArmy
import game.testInterfaces.TestFightable

object TestBattle : TestFightable {

    override fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender,FightType.Classic)

            (defender.warriorBehind as? Healer)?.heal(defender, FightType.Classic)


            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }

    override fun straightFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender,FightType.Straight)

            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }

    override fun straightFight(army1: TestArmy, army2: TestArmy): Boolean {
       while (army1.hasTroopsLeft && army2.hasTroopsLeft) {
           val size = when {
               army1.size < army2.size -> army1.size
               army1.size > army2.size -> army2.size
               else -> {
                   army1.size
               }
           }
           val deadPositionsArmy1 = mutableListOf<Int>()
           val deadPositionsArmy2 = mutableListOf<Int>()
           for (i in 0 until size) {
               if (fight(army1.getWarriorAtPosition(i), army2.getWarriorAtPosition(i))) {
                   deadPositionsArmy2.add(i)
               } else {
                   deadPositionsArmy1.add(i)
               }
           }

           for (i in 0 until deadPositionsArmy1.size) {
               army1.killedWarrior(i)
           }
           for (i in 0 until deadPositionsArmy2.size) {
               army2.killedWarrior(i)
           }
       }

        return army1.hasTroopsLeft
    }


    override fun fight(army1: TestArmy, army2: TestArmy): Boolean {
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

