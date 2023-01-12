import game.characters.Knight
import game.characters.Warlord
import game.interactions.Battle.fight


fun main() {
    val ronald = Warlord()
    val heimdall = Knight()

    assert(fight(heimdall, ronald) == false)



    print("OK")
  
}


