package game.factory

import game.characters.*
import game.enums.WarriorType
import game.interfaces.BaseWarrior
import java.util.*


fun getWarrior(type: WarriorType): BaseWarrior {
    val warrior: BaseWarrior = when (type) {
        WarriorType.Knight -> Knight(Warrior())
        WarriorType.Vampire -> Vampire(Warrior())
        WarriorType.Warrior -> Warrior()
        WarriorType.Lancer -> Lancer(Warrior())
        WarriorType.Defender -> Defender(Warrior())
    }

    return warrior
}

