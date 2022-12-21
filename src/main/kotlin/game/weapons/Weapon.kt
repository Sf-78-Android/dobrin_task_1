package game.weapons

import game.decorators.WeaponDecorator

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
            return this.health ?: 0
        }

        override fun getAttack(): Int {
            return this.attack ?: 0
        }

        override fun getDefence(): Int {
            return this.defence ?: 0
        }

        override fun getVampirism(): Int {
            return this.vampirism ?: 0
        }

        override fun getHealingPower(): Int {
            return this.healingPower ?: 0
        }
    }


}

