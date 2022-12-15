package game.factory

import game.characters.*
import game.interfaces.BaseWarrior
import java.util.*


fun  getWarrior(type : String) :  BaseWarrior {
        lateinit var warrior : BaseWarrior
    if (type.isNotEmpty() and type.isNotBlank()) {
        when (type.lowercase(Locale.getDefault())) {
            "knight" -> warrior = Knight(Warrior())
            "vampire" -> warrior = Vampire(Warrior())
            "warrior" -> warrior = Warrior()
            "lancer" -> warrior = Lancer(Warrior())
            "defender" -> warrior = Defender(Warrior())
        }
    }

    return  warrior
    }

