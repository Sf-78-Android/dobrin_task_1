package game.testFactory

import game.characters.*
import game.interfaces.BaseWarrior
import game.testClass.Rookie
import java.util.*


fun  getWarrior(type : String) :  BaseWarrior {
         var warrior : BaseWarrior? = null
    if (type.isNotEmpty() and type.isNotBlank()) {
        when (type.lowercase(Locale.getDefault())) {
            "knight" -> warrior = Knight(Warrior())
            "vampire" -> warrior = Vampire(Warrior())
            "warrior" -> warrior = Warrior()
            "lancer" -> warrior = Lancer(Warrior())
            "defender" -> warrior = Defender(Warrior())
            "rookie" -> warrior = Rookie(Warrior())
        }
    }

    return  warrior!!
    }

