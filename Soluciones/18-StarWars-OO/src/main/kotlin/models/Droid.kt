package models

import kotlin.math.min

/**
 * Represents a Droid object with various properties and behaviors.
 *
 * @property maxEnergy The maximum energy level of the Droid.
 * @property type The type of the Droid.
 * @property defense The defense level of the Droid.
 * @property shield The shield level of the Droid.
 * @property velocity The velocity level of the Droid.
 * @property color The color representation of the Droid based on its type.
 */
class Droid private constructor(
    var maxEnergy: Int,
    val type: Type,
    val defense: Int,
    val shield: Int,
    val velocity: Int
) {

    val color: String
        get() {
            return when (type) {
                Type.SW348 -> "[🔴]"
                Type.SW447 -> "[🔵]"
                Type.SW421 -> "[🟢]"
            }
        }

    companion object {
        /**
         * Generates a random Droid object with various properties.
         *
         * @return A randomly generated Droid object.
         */
        fun random(): Droid {
            val random = (1..100).random()
            return when {
                random <= 30 -> Droid(50, Type.SW348, (9..12).random(), 0, 0)
                random <= 80 -> Droid(100, Type.SW447, 0, (5..10).random(), 0)
                else -> Droid((100..150).random(), Type.SW421, 0, 0, (10..30).random())
            }
        }

        /**
         * Creates a Droid object based on the given Type.
         *
         * @param type The type of the Droid. It can be one of the following: SW348, SW447, or SW421.
         * @return A Droid object with the specified type. The Droid object's properties are set based on the given type.
         */
        fun fromType(type: Type): Droid {
            return when (type) {
                Type.SW348 -> Droid(50, type, (9..12).random(), 0, 0)
                Type.SW447 -> Droid(100, type, 0, (5..10).random(), 0)
                Type.SW421 -> Droid((100..150).random(), type, 0, 0, (10..30).random())
            }
        }
    }

    /**
     * Checks if the entity is alive.
     *
     * @return true if the entity is alive, false otherwise.
     */
    val isAlive: Boolean
        get() = maxEnergy > 0
    

    override fun toString(): String {
        return "Droid(maxEnergy=$maxEnergy, type=$type, defense=$defense, shield=$shield, velocity=$velocity)"
    }

    /**
     * Defends against incoming damage.
     *
     * @param damage The amount of damage to be defended against.
     * @return The remaining damage after defending.
     * @throws IllegalStateException If the droid type is not Type.SW348.
     */
    fun defend(damage: Int): Int {
        check(this.type == Type.SW348) { "You cannot defend this type of droid" }
        println("Enemy tries to defend with $defense")
        return min(damage, defense)
    }

    /**
     * Moves the droid.
     *
     * @return true if the droid successfully moved, false otherwise
     * @throws IllegalStateException if the droid type is not Type.SW421
     */
    fun move(): Boolean {
        check(this.type == Type.SW421) { "You cannot move this type of droid" }
        println("Enemy tries to move with $velocity")
        return (1..100).random() <= velocity
    }


    // Una clase anidada
    enum class Type {
        SW348, SW447, SW421
    }
}
