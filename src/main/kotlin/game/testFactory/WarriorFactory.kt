package game.testFactory

import game.characters.*
import game.interfaces.BaseWarrior
import java.util.*

fun  getWarrior(type : String) :  BaseWarrior {
        lateinit var warrior : BaseWarrior
    if (type.isNotEmpty() and type.isNotBlank()) {
        when (type.lowercase(Locale.getDefault())) {
            "knight" -> warrior = Knight(Warrior())
            "warrior" -> warrior = Warrior()

        }
    }

    return  warrior
    }

