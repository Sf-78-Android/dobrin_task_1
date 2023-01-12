package game.weapons

import game.decorators.WeaponDecorator
import game.settings.Constants

open class Weapon : WeaponDecorator() {

    data class Builder(
        private var health: Int? = null,
        private var attack: Int? = null,
        private var defence: Int? = null,
        private var vampirism: Int? = null,
        private var healingPower: Int? = null
    ) : WeaponDecorator() {

        fun health(health: Int) = apply { this.health = health }
        fun attack(attack: Int) = apply { this.attack = attack }
        fun defence(defence: Int) = apply { this.defence = defence }
        fun vampirism(vampirism: Int) = apply { this.vampirism = vampirism }
        fun healingPower(healingPower: Int) = apply { this.healingPower = healingPower }


        override fun getHealth(): Int {
            return this.health ?: Constants.ZERO
        }

        override fun getAttack(): Int {
            return this.attack ?: Constants.ZERO
        }

        override fun getDefence(): Int {
            return this.defence ?: Constants.ZERO
        }

        override fun getVampirism(): Int {
            return this.vampirism ?: Constants.ZERO
        }

        override fun getHealingPower(): Int {
            return this.healingPower ?: Constants.ZERO
        }
    }


}

