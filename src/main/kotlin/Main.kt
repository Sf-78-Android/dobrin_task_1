import game.characters.*
import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import game.interactions.Battle.fight
import game.interfaces.BaseWarrior
import game.settings.Constants
import log.constants.MsgTemplate.armyCreationMsg
import log.constants.MsgTemplate.armyMsg
import log.constants.MsgTemplate.firstWarriorCreationMsg
import log.constants.MsgTemplate.secondWarriorCreationMsg
import log.constants.MsgTemplate.startGameMsg
import java.lang.System.`in`
import java.util.Scanner


fun main() {
    val sc = Scanner(`in`)


    println(startGameMsg)
    while (sc.hasNextInt()) {

        when (sc.nextInt()) {

            1 -> singleFightGame(sc)

            2 -> armyClassicFightGame(sc)
            else -> break
        }
        println(startGameMsg)
    }
}

fun armyClassicFightGame(sc: Scanner) {
    val army1 = Army()
    val army2 = Army()
    var currentArmy: Army?

    for (i in Constants.ZERO..Constants.ONE) {
        currentArmy = if (i == Constants.ZERO) {
            army1
        } else {
            army2
        }
        println("Please insert army name:")
        val name = readln()
        currentArmy.setArmyName(name)
        println(armyMsg)
        var select = sc.nextInt()
        while (select != Constants.NINE) {

            println(armyCreationMsg)
            println("Warrior Type:")
            select = sc.nextInt()
            if (select == Constants.NINE) {
                break
            }
            val warrior = getWarriorType(select)
            println("Count: ")
            select = sc.nextInt()
            val count = select
            currentArmy.addUnits(count, warrior)
        }

    }
    fight(army1, army2)
    Battle.getLog().printLog()

}

fun getWarriorType(select: Int): WarriorType {
    return when (select) {
        1 -> WarriorType.Warrior
        2 -> WarriorType.Knight
        3 -> WarriorType.Lancer
        4 -> WarriorType.Healer
        5 -> WarriorType.Defender
        6 -> WarriorType.Vampire
        7 -> WarriorType.Archer
        else -> WarriorType.Warlord
    }
}

fun singleFightGame(sc: Scanner) {

    println(firstWarriorCreationMsg)
    while (sc.hasNextInt()) {
        var select = sc.nextInt()
        if (select == Constants.NINE) {
            break
        }
        val warrior1: BaseWarrior = getWarrior(select)
        println(secondWarriorCreationMsg)
        select = sc.nextInt()
        val warrior2: BaseWarrior = getWarrior(select)
        fight(warrior1, warrior2)
        Battle.getLog().printLog()
        break
    }
}

private fun getWarrior(sc: Int): BaseWarrior {
    return when (sc) {
        1 -> Warrior()
        2 -> Knight()
        3 -> Lancer()
        4 -> Healer()
        5 -> Defender()
        6 -> Vampire()
        7 -> Archer()
        else -> Warlord()
    }
}

