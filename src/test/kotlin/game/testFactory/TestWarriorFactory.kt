package game.testFactory

import game.characters.*
import game.enums.WarriorType
import game.interfaces.BaseWarrior


fun getWarrior(type: WarriorType): BaseWarrior {
    val warrior: BaseWarrior = when (type) {
        WarriorType.Knight -> Knight()
        WarriorType.Vampire -> Vampire()
        WarriorType.Warrior -> Warrior()
        WarriorType.Lancer -> Lancer()
        WarriorType.Defender -> Defender()
        WarriorType.Healer -> Healer()
        WarriorType.Warlord -> Warlord()
        WarriorType.Archer -> Archer()
    }

    return warrior
}

