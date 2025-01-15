package models

class Sw447(
    maxEnergy: Int = 100,
    val shield: Int,
) : Droid(maxEnergy) {

    override val color get() = "[🔵]"
    override fun saludar() {
        println("Hola soy un SW447")
    }

    override fun toString(): String {
        return "Sw447(energy=$energy, shield=$shield)"
    }
}