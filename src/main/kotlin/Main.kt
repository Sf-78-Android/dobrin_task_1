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



    print("OK")
  
}


