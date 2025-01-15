package models

import Defensa
import kotlin.math.min

class Sw348(
    maxEnergy: Int = 50,
    val defense: Int,
) : Droid(maxEnergy), Defensa {

    override val color get() = "[🟢]"
    override fun saludar() {
        println("Hola soy un SW348")
    }

    /**
     * Defends against incoming damage.
     *
     * @param damage The amount of damage to be defended against.
     * @return The remaining damage after defending.
     */
    override fun defend(damage: Int): Int {
        println("Enemy tries to defend with $defense")
        return min(damage, defense)
    }

    override fun toString(): String {
        return "Sw348(energy=$energy, defense=$defense)"
    }
}