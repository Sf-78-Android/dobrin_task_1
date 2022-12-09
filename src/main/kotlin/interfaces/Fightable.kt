package interfaces

import characters.Warrior
import collections.Army

interface Fightable {
    fun fight(army1: Army, army2: Army): Boolean
    fun fight(warrior1: Warrior, warrior2: Warrior): Boolean
    fun fight(warrior1: Warrior, warrior2: Warrior, piercedWarrior: Warrior?): Boolean
}