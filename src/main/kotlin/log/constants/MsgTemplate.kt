package log.constants

object MsgTemplate {
    const val fightWinner = "%s defeated %s and has %d health left."
    const val archerHitsWarlord = "%s hits %s for triple damage of %d"
    const val moveUnitsMsg = "Warlord ordered units to take formation."
    const val lancerHitMsg = "%s hits %s for %d damage and pierces %s for %d damage."
    const val warriorHitMsg = "%s hits %s for %d damage and leaves him with %d health left."
    const val healerMsg = "%s heals %s raising his hp to %d."
    const val vampireHit = "%s hits %s for %d damage and restored his own hp to %d."
    const val weaponEquipMsg = "%s equipped %s"
    const val armyWinnerMsg = "%s won against %s"
    const val startGameMsg = """
        WELCOME! PLEASE CHOOSE YOUR GAME!
        (1) Single Warrior Fight
        (2) Fight with armies
        
        (3) Exit
    """
    const val firstWarriorCreationMsg = """
        PLEASE SELECT FIRST WARRIOR TYPE
        (1) Warrior
        (2) Knight
        (3) Lancer
        (4) Healer
        (5) Defender
        (6) Vampire
        (7) Archer
        (8) Warlord
        
        (9) Cancel
    """
    const val secondWarriorCreationMsg = """
        PLEASE SELECT SECOND WARRIOR TYPE
        (1) Warrior
        (2) Knight
        (3) Lancer
        (4) Healer
        (5) Defender
        (6) Vampire
        (7) Archer
        (8) Warlord
        
        (9) Cancel
    """
    const val armyCreationMsg = """
        PLEASE CREATE AN ARMY
       *You choose type of warrior and count
        (1) Warrior
        (2) Knight
        (3) Lancer
        (4) Healer
        (5) Defender
        (6) Vampire
        (7) Archer
        (8) Warlord
        
        (9) Done
    """

const val armyMsg = """
        PLEASE CREATE AN ARMY
       *You choose type of warrior and count
        (1) Add warriors
        
        
        (9) Done
    """




}