package models

class Sw421(
    maxEnergy: Int,
    val velocity: Int,
) : Droid(maxEnergy) {

    override val color get() = "[🔴]"

    override fun saludar() {
        println("Hola soy un SW421")
    }

    override fun toString(): String {
        return "Sw421(energy=$energy, velocity=$velocity)"
    }

    /**
     * Moves the droid.
     *
     * @return true if the droid successfully moved, false otherwise
     */
    fun move(): Boolean {
        println("Enemy tries to move with $velocity")
        return (1..100).random() <= velocity
    }
}