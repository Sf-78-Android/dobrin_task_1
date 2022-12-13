package game.factory

import game.characters.*
import game.interfaces.BaseWarrior

// TODO validation and not case sensitive
fun  getWarrior(type : String) :  BaseWarrior {
         var warrior : BaseWarrior? = null
        when(type){
            "Knight" -> warrior = Knight(Warrior())
            "Vampire" -> warrior = Vampire(Warrior())
            "Warrior" -> warrior = Warrior()
            "Lancer" -> warrior = Lancer(Warrior())
            "Defender" -> warrior = Defender(Warrior())
        }

    return  warrior!!
    }

