package game.interactions

import game.collections.Army
import game.commands.AddOrders
import game.commands.Sender
import game.enums.FightType
import game.interfaces.BaseWarrior
import game.interfaces.Fightable

object Battle : Fightable {
    private val sender = Sender()


    override fun fight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender, FightType.Classic)
            if (!singleFight(warrior1, warrior2)) {
                sender.commandHeal(attacker)
            }
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }

    private fun singleFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        return warrior1.warriorBehind == null && warrior1.warriorIfFront == null &&
                warrior2.warriorBehind == null && warrior2.warriorIfFront == null
    }


    override fun straightFight(warrior1: BaseWarrior, warrior2: BaseWarrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive && defender.isAlive) {
            attacker.hit(defender, FightType.Straight)

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
            val deadPositionsArmy1 = mutableListOf<BaseWarrior>()
            val deadPositionsArmy2 = mutableListOf<BaseWarrior>()
            for (i in 0 until size) {
                if (straightFight(army1.getWarriorAtPosition(i), army2.getWarriorAtPosition(i))) {
                    deadPositionsArmy2.add(army2.getWarriorAtPosition(i))
                } else {
                    deadPositionsArmy1.add(army1.getWarriorAtPosition(i))
                }
            }

            for (i in 0 until deadPositionsArmy1.size) {
                army1.killedWarrior(deadPositionsArmy1[i])
            }
            for (i in 0 until deadPositionsArmy2.size) {
                army2.killedWarrior(deadPositionsArmy2[i])
            }
        }

        return army1.hasTroopsLeft
    }


    override fun fight(army1: Army, army2: Army): Boolean {
        AddOrders(sender, mutableListOf(army1, army2))
        sender.commandMove()
        while (army1.hasTroopsLeft && army2.hasTroopsLeft) {
            val warrior1 = army1.nextWarrior()
            val warrior2 = army2.nextWarrior()
            fight(warrior1, warrior2)
            sender.clearDead()
            sender.commandMove()
        }
        return army1.hasTroopsLeft
    }


}

