package interfaces

import characters.Warrior
import collections.Army

interface AbleToFight {
    fun fight(army1: Army, army2: Army): Boolean
    fun fight(warrior1: Warrior, warrior2: Warrior): Boolean
}