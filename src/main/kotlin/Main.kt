import game.characters.Archer
import game.characters.Warrior
import game.collections.Army
import game.enums.WarriorType
import game.interactions.Battle
import game.interactions.Battle.fight
import game.settings.Params
import game.weapons.GreatAxe
import game.weapons.Sword
import game.weapons.Weapon


fun main() {

    val army1 = Army()
    val army2 = Army()

    army1.addUnits(2,WarriorType.Lancer)
    army1.equipWarriorAtPosition(1, Sword())
    army1.equipWarriorAtPosition(0, Weapon.Builder(10,10))
    army1.addUnits(2,WarriorType.Archer)
    army1.addUnits(2,WarriorType.Vampire)
    army1.addUnits(1,WarriorType.Warlord)

    army1.equipWarriorAtPosition(3, GreatAxe())
    army2.addUnits(3,WarriorType.Knight)
    army2.addUnits(3,WarriorType.Knight)
    army2.addUnits(3,WarriorType.Healer)
    army2.addUnits(1,WarriorType.Warlord)
    army2.equipWarriorAtPosition(0, Sword())

    fight(army1,army2)




    Battle.getLog().printLog()

  
}


