package interactions

import characters.Lancer
import characters.Warrior
import collections.Army
import interfaces.Fightable

object Battle : Fightable {

    override fun fight(warrior1: Warrior, warrior2: Warrior): Boolean {
        var attacker = warrior1
        var defender = warrior2
        while (attacker.isAlive) {
            attacker.hit(defender)
            attacker = defender.also { defender = attacker }
        }
        return warrior1.isAlive
    }


    override fun fight(army1: Army, army2: Army): Boolean {
        while (army1.hasTroopsLeft && army2.hasTroopsLeft) {
            val warrior1 = army1.nextWarrior()
            val piercedWarrior1 = army1.piercedWarrior()
            val warrior2 = army2.nextWarrior()
            val piercedWarrior2 = army2.piercedWarrior()


            if (warrior1 is Lancer || warrior2 is Lancer) {
                if (fight(warrior1, warrior2, piercedWarrior1, piercedWarrior2)) {
                    if (piercedWarrior2 != null && !piercedWarrior2.isAlive) {
                        army2.killedPiercedWarrior()
                    }
                    army2.killedWarrior()
                } else {
                    if (piercedWarrior1 != null && !piercedWarrior1.isAlive) {
                        army1.killedPiercedWarrior()
                    }
                    army1.killedWarrior()
                }
            } else {

                if (fight(warrior1, warrior2)) {
                    army2.killedWarrior()
                } else {
                    army1.killedWarrior()
                }
            }
        }
        return army1.hasTroopsLeft
    }
// TODO Below fun needs to be refactored

    override fun fight(
        warrior1: Warrior,
        warrior2: Warrior,
        piercedWarrior1: Warrior?,
        piercedWarrior2: Warrior?
    ): Boolean {
        var attacker = warrior1
        var attPiercedWarrior = piercedWarrior1
        var defender = warrior2
        var defPiercedWarrior = piercedWarrior2
        while (attacker.isAlive) {
            if (attacker is Lancer) {
                if (defPiercedWarrior != null && defPiercedWarrior.isAlive) {
                    attacker.hitAndPierce(defender, defPiercedWarrior)
                } else {
                    attacker.hit(defender)
                }

            } else {
                attacker.hit(defender)
            }
            attacker = defender.also { defender = attacker }
            attPiercedWarrior = defPiercedWarrior.also { defPiercedWarrior = attPiercedWarrior }
        }
        return warrior1.isAlive
    }
}

