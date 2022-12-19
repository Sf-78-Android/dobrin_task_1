package game.settings

object Params {
    object Warrior {
        const val HEALTH = 50
        const val ATTACK = 5
    }
    object Knight {
        const val HEALTH = 50
        const val ATTACK = 7
    }
    object Defender {
        const val HEALTH = 60
        const val ATTACK = 4
        const val DEFENCE = 3
    }
    object Vampire {
        const val HEALTH = 40
        const val ATTACK = 4
        const val VAMPIRISM = 50
    }
    object Lancer {
        const val HEALTH = 60
        const val ATTACK = 6
        const val PIERCING_POWER = 50
    }
    object TestRookie {
        const val HEALTH = 3
        const val ATTACK = 0
    }
    object Healer {
        const val HEALTH = 60
        const val ATTACK = 0
        const val healingPower  = 2
    }
}