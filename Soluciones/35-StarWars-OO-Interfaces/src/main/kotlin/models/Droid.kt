package models

/**
 * Represents a Droid object with various properties and behaviors.
 *
 * @property maxEnergy The maximum energy level of the Droid.
 * @property color The color representation of the Droid based on its type.
 */
// Debes ver la diferencia entre la clase abstracta y las clases hijas.

abstract class Droid(
    var maxEnergy: Int
) {

    abstract val color: String

    val energy: Int
        get() = if (maxEnergy < 0) 0 else maxEnergy


    /**
     * Checks if the entity is alive.
     *
     * @return true if the entity is alive, false otherwise.
     */
    val isAlive: Boolean
        get() = maxEnergy > 0

    abstract fun saludar()

}
