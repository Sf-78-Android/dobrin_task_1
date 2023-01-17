package game.commands

import game.characters.Archer
import game.characters.Healer
import game.characters.Lancer
import game.characters.Warlord
import game.interactions.Battle
import game.interfaces.BaseWarrior
import game.settings.Constants
import log.constants.MsgTemplate.moveUnitsMsg
import java.util.*
import kotlin.random.Random

open class Receiver {
    val units = mutableListOf<BaseWarrior>()
    var sorted : Boolean = false
    fun heal() {

        for (warrior in units) {
            if (warrior is Healer && warrior.isAlive) {
                warrior.warriorIfFront?.let { warrior.heal(it) }
            }
        }
    }

    fun sendArrows(targets: Receiver){
       for (warrior in units) {
           if (warrior is Archer && warrior.isAlive && warrior.warriorIfFront != null) {
               val randomIndex : Int = Random.nextInt(Constants.ZERO, targets.units.size)
               warrior.shoot(targets.units[randomIndex])
           }
       }
    }

    fun moveUnits() {
        if (this.containsWarlord()) {
            val healers = getHealers()
            val lancers = getLancers(LinkedList<Lancer>())
            val otherUnits = getOtherUnits()
            val archers = getArchers(LinkedList<Archer>())


            val warlord = getWarlord()
            this.units[this.units.size - Constants.ONE] =
                warlord.also { this.units[this.units.indexOf(warlord)] = units[units.size - Constants.ONE] }



            if (units[Constants.ZERO] !is Lancer && !lancers.isEmpty()) {
                val lancer = lancers.poll()
                this.units[Constants.ZERO] = this.units[units.indexOf(lancer)].also { this.units[units.indexOf(lancer)] = this.units[Constants.ZERO] }
            } else if (!otherUnits.isEmpty()  && units[Constants.ZERO] !is Lancer) {
                val unit = otherUnits.poll()
                units[Constants.ZERO] = unit.also { units[units.indexOf(unit)] = units[Constants.ZERO] }
            }
            var index = Constants.ONE
            while (!healers.isEmpty() && !otherUnits.isEmpty()) {
                val healer = healers.poll()
                units[index] = healer.also { units[units.indexOf(healer)] = units[index] }
                index++
            }

            index = units.size-2
            while (!archers.isEmpty() && !otherUnits.isEmpty()){
                val archer = archers.poll()
                units[index] = units[units.indexOf(archer)].also { units[units.indexOf(archer)] = units[index] }
                index--
            }


            updatePositions()
            Battle.getLog().logMessage(moveUnitsMsg)
            sorted = true
        }
    }

    private fun getArchers(queue : LinkedList<Archer>): LinkedList<Archer> {
        val archers = this.units.stream().filter { it is Archer }.toList()
        for (archer in archers) {
            queue.add(archer as Archer)
        }
        return queue
    }

    fun containsWarlord(): Boolean {
       return  units.stream().filter { it is Warlord }.count().toInt() == Constants.ONE
    }


    protected fun updatePositions() {

        for (i in Constants.ONE until units.size) {
            units[i - Constants.ONE].warriorBehind = units[i]
            units[i].warriorIfFront = units[i - Constants.ONE]
        }
        units[units.size - Constants.ONE].warriorBehind = null

    }

    private fun getLancers(queue: LinkedList<Lancer>): LinkedList<Lancer> {
        val lancers = this.units.stream().filter { it is Lancer }.toList()
        for (lancer in lancers) {
            queue.add(lancer as Lancer)
        }
        return queue
    }

    private fun getOtherUnits(): LinkedList<BaseWarrior> {
        val queue = LinkedList<BaseWarrior>()
        val warriors = units.stream().filter { it !is Lancer && it !is Healer && it !is Warlord && it !is Archer }.toList()
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
        if (newList.size > Constants.ZERO ){
            sorted = false
        }
        units.removeAll(newList)
    }

    fun contains(attacker: BaseWarrior): Boolean {
        return units.contains(attacker)
    }


}