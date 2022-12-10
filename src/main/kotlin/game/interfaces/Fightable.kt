package game.interfaces

import game.characters.Warrior
import game.collections.Army

interface Fightable {
    fun fight(army1: Army, army2: Army): Boolean
    fun fight(warrior1: Warrior, warrior2: Warrior): Boolean
   // fun fight(warrior1: Warrior, warrior2: Warrior, piercedWarrior1: Warrior?, piercedWarrior2: Warrior?): Boolean
}