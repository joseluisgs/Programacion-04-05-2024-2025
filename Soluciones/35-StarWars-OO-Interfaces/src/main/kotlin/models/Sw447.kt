package models

import Defensa
import kotlin.math.min

class Sw447(
    maxEnergy: Int = 100,
    val shield: Int,
) : Droid(maxEnergy), Defensa, Movimiento, Escudo {

    override val color get() = "[🔵]"
    override fun saludar() {
        println("Hola soy un SW447")
    }

    override fun defend(damage: Int): Int {
        println("Enemy tries to defend with $shield")
        return min(damage, shield)
    }

    override fun move(): Boolean {
        println("Enemy tries to move with $shield")
        return (1..100).random() <= shield
    }

    override fun protect(damage: Int): Int {
        println("Enemy tries to protect with $shield")
        return if (shield > damage) 0 else damage - shield
    }

    override fun toString(): String {
        return "Sw447(energy=$energy, shield=$shield)"
    }
}