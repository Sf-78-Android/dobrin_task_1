import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle


fun main() {


    val army1 = Army().apply {
        addUnits(1, WarriorType.Warrior)
        addUnits(1, WarriorType.Knight)
        addUnits(1, WarriorType.Lancer)
        addUnits(1, WarriorType.Defender)
        addUnits(1, WarriorType.Vampire)
    }


    val army2 = Army().apply {
        addUnits(1, WarriorType.Warrior)
        addUnits(1, WarriorType.Knight)
        addUnits(1, WarriorType.Lancer)
        addUnits(3, WarriorType.Defender)
        addUnits(1, WarriorType.Vampire)
    }

    check(!Battle.fight(army1, army2))


    println("OK")


}


