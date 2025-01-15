package models

const val PROB_ESPECIAL = 10
const val PROB_VIP = 30
const val PROB_NORMAL = 60

/**
 * Vamos a aplicar un patrón de diseño llamado Factory
 * Anulando el constructor por defecto y creando un factory
 * para crear las butacas según necesitemos, por ejemplo:
 * - Butaca.default() -> Butaca()
 * - Butaca.random() -> Butaca() o Butaca(tipo = TipoButaca.ESPECIAL) o Butaca(tipo = TipoButaca.VIP)
 */

class Butaca private constructor(
    val id: Int = 0,
    var ocupada: Boolean = false,
    val tipo: Tipo = Tipo.NORMAL
) {

    // Hacemos un factory con companion object
    companion object {
        private var idCounter = 0
        private fun nextId(): Int {
            return idCounter++
        }

        fun default(): Butaca {
            return Butaca(id = nextId())
        }

        fun vip(): Butaca {
            return Butaca(tipo = Tipo.VIP, id = nextId())
        }

        fun especial(): Butaca {
            return Butaca(tipo = Tipo.ESPECIAL, id = nextId())
        }

        fun random(): Butaca {
            val random = (0..100).random()
            return when {
                random <= PROB_ESPECIAL -> Butaca(tipo = Tipo.ESPECIAL, id = nextId())
                random <= PROB_VIP -> Butaca(tipo = Tipo.VIP, id = nextId())
                else -> Butaca()
            }
        }
    }

    override fun toString(): String {
        return when (ocupada) {
            true -> "[🔴]"
            false -> when (tipo) {
                Tipo.NORMAL -> "[🟢]"
                Tipo.ESPECIAL -> "[🔵]"
                Tipo.VIP -> "[🟣]"
            }
        }
    }

    enum class Tipo(val precio: Double) {
        NORMAL(5.00), ESPECIAL(7.50), VIP(10.00)
    }
}