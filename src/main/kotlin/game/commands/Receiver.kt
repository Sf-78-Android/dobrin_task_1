package game.commands

import game.characters.Healer
import game.characters.Lancer
import game.characters.Warlord
import game.interfaces.BaseWarrior
import java.util.*

open class Receiver  {
    val units = mutableListOf<BaseWarrior>()
    fun heal() {
        for (warrior in units ) {
            if (warrior is Healer && warrior.isAlive) {
                warrior.warriorIfFront?.let { warrior.heal(it) }
            }
        }
    }

    fun moveUnits() {
        val warlord = getWarlord()
        val healers = getHealers()
        val lancers = getLancers()
        val otherUnits = getOtherUnits()
        this.units[this.units.size - 1] = warlord.also { this.units[this.units.indexOf(warlord)] = units[units.size - 1] }


        if (units[0] !is Lancer && !lancers.isEmpty()) {
            val lancer = lancers.poll()
            this.units[0] = this.units[lancer].also { this.units[lancer] = this.units[0] }
        } else if (!otherUnits.isEmpty() && !healers.isEmpty() && units[0] !is Lancer) {
            val unit = otherUnits.poll()
            units[0] = unit.also { units[units.indexOf(unit)] = units[0] }
        }
        var index = 1
        while (!healers.isEmpty() && !otherUnits.isEmpty()) {
            val healer = healers.poll()
            units[index] = healer.also { units[units.indexOf(healer)] = units[index] }
            index++
        }

        updatePositions()
    }

     fun containsWarlord(): Boolean {
        for (unit in units){
            if (unit is Warlord){
                return true
            }
        }
        return false
    }


    private fun updatePositions() {

        for (i in 1 until units.size-1){
            units[i-1].warriorBehind = units[i]
            units[i].warriorIfFront = units[i-1]
        }
        units[units.size-1].warriorBehind = null

    }

    private fun getLancers(): LinkedList<Int> {
        val queue = LinkedList<Int>()
        val lancers = this.units.stream().filter { it is Lancer }.toList()
        for (lancer in lancers) {
            queue.add(units.indexOf(lancer))
        }
        return queue
    }

    private fun getOtherUnits(): LinkedList<BaseWarrior> {
        val queue = LinkedList<BaseWarrior>()
        val warriors = units.stream().filter { it !is Lancer && it !is Healer && it !is Warlord }.toList()
        for (warrior in warriors) {
            queue.add(warrior)
        }
        return queue
    }



    private fun getHealers(): LinkedList<BaseWarrior> {
        val queue = LinkedList<BaseWarrior>()
        val healers = units.stream().filter { it is Healer }.toList()
        for (healer in healers) {
            queue.add(healer)
        }
        return queue
    }

    private fun getWarlord(): BaseWarrior {
        return units.stream().filter { it is Warlord }.findFirst().get()
    }

    fun clearDeadBodies() {
        val newList: MutableList<BaseWarrior> = ArrayList()
        units.filter { !it.isAlive }.forEach { newList.add(it) }
        units.removeAll(newList)
    }

    fun contains(attacker: BaseWarrior): Boolean {
        return units.contains(attacker)
    }
}