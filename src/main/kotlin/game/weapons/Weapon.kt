package game.weapons

open class Weapon(
    private val health: Int, private val attack: Int, private val defence: Int,
    private val vampirism: Int, private val healingPower: Int
) {
 val getHealth : Int
    get() = health
   val getAttack : Int
      get() = attack
   val getDefence : Int
      get() = defence
   val getVampirism : Int
      get() = vampirism
   val getHealingPower: Int
      get() =healingPower
}

