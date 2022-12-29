import game.characters.Healer
import game.characters.Knight
import game.characters.Lancer
import game.characters.Warlord
import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle.fight
import game.characters.Vampire as Vampire


fun main() {
    val ronald = Warlord()
    val heimdall = Knight()

    assert(fight(heimdall, ronald) == false)

    val myArmy = Army()
    myArmy.addUnits(1, WarriorType.Warlord)
    myArmy.addUnits(2, WarriorType.Warrior)
    myArmy.addUnits(2, WarriorType.Lancer)
    myArmy.addUnits(2, WarriorType.Healer)

    val enemyArmy = Army()
    enemyArmy.addUnits(3, WarriorType.Warlord)
    enemyArmy.addUnits(1, WarriorType.Vampire)
    enemyArmy.addUnits(2, WarriorType.Healer)
    enemyArmy.addUnits(2, WarriorType.Knight)

    myArmy.moveUnits()
    enemyArmy.moveUnits()

// you can provide any other interface for testing the order
    assert(myArmy.getWarriorAtPosition(0) is Lancer)
    assert(myArmy.getWarriorAtPosition(1) is Healer)
// negative index means from the last position, so -1 == last
    assert(myArmy.getWarriorAtPosition(myArmy.size-1) is Warlord)

    assert(enemyArmy.getWarriorAtPosition(0)is Vampire)
    assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-1) is Warlord)
    assert(enemyArmy.getWarriorAtPosition(enemyArmy.size-2) is Knight)

//6, not 8, because only 1 Warlord per army could be
    assert(enemyArmy.size == 6)

    assert(fight(myArmy, enemyArmy) == true)

    print("OK")
  
}


