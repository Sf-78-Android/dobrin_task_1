package game.settings

object Params {
    object Warrior {
        const val HEALTH = 50
        const val ATTACK = 5
        const val DEFENCE = 0
        const val VAMPIRISM = 0
        const val HEALING_POWER  = 0
    }
    object Knight {
        const val HEALTH = 50
        const val ATTACK = 7
        const val DEFENCE = 0
        const val VAMPIRISM = 0
        const val HEALING_POWER  = 0
    }
    object Defender {
        const val HEALTH = 60
        const val ATTACK = 4
        const val DEFENCE = 3
        const val VAMPIRISM = 0
        const val HEALING_POWER  = 0
    }
    object Vampire {
        const val HEALTH = 40
        const val ATTACK = 4
        const val DEFENCE = 0
        const val VAMPIRISM = 50
        const val HEALING_POWER  = 0
    }
    object Lancer {
        const val HEALTH = 60
        const val ATTACK = 6
        const val PIERCING_POWER = 50
        const val DEFENCE = 0
        const val VAMPIRISM = 0
        const val HEALING_POWER  = 0
    }

    object Healer {
        const val HEALTH = 60
        const val ATTACK = 0
        const val HEALING_POWER  = 2
        const val DEFENCE = 0
        const val VAMPIRISM = 0
    }

    // Weapons

    object Sword {
        const val HEALTH = 5
        const val ATTACK = 2
        const val HEALING_POWER  = 0
        const val DEFENCE = 0
        const val VAMPIRISM = 0
    }

    object Shield {
        const val HEALTH = 20
        const val ATTACK = -1
        const val DEFENCE = 2
        const val HEALING_POWER  = 0
        const val VAMPIRISM = 0

    }

    object GreatAxe {
        const val HEALTH = -15
        const val ATTACK = +5
        const val DEFENCE = -2
        const val VAMPIRISM = 10
        const val HEALING_POWER  = 0
    }

    object Katana {
        const val HEALTH = -20
        const val ATTACK = +6
        const val DEFENCE = -5
        const val VAMPIRISM = 50
        const val HEALING_POWER  = 0
    }

    object MagicWand {
        const val HEALTH = 30
        const val ATTACK = +3
        const val DEFENCE = 0
        const val HEALING_POWER = 3
        const val VAMPIRISM = 0
    }
}