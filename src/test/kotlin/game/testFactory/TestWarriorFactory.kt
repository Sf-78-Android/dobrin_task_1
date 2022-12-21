package game.testFactory

import game.characters.*
import game.testEnum.TestWarriorType
import game.interfaces.BaseWarrior
import game.testCharachters.Rookie


fun getWarrior(type: TestWarriorType): BaseWarrior {
    val warrior: BaseWarrior = when (type) {
        TestWarriorType.Knight -> Knight()
        TestWarriorType.Vampire -> Vampire()
        TestWarriorType.Warrior -> Warrior()
        TestWarriorType.Lancer -> Lancer()
        TestWarriorType.Defender -> Defender()
        TestWarriorType.Healer -> Healer()
        TestWarriorType.Rookie -> Rookie()
    }

    return warrior
}

