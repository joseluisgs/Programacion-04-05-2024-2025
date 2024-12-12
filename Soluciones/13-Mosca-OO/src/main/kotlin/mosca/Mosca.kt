package mosca

const val MAX_VIDAS = 2

/**
 * Clase que representa una mosca
 * @property maxVidas Número máximo de vidas
 * @property isAlive Indica si la mosca está viva
 */
class Mosca(var maxVidas: Int = MAX_VIDAS) {

    //fun isAlive() = maxVidas > 0

    val isAlive: Boolean
        get() = maxVidas > 0

    /**
     * Mata a la mosca restando una vida
     */
    fun kill() {
        maxVidas -= 1
    }

    override fun toString(): String {
        return "🪰"
    }

}