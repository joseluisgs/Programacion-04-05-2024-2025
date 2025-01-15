class Vehiculo(
    // Estado del objeto
    var marca: String,
    var modelo: String,
    var matricula: String,
) {
    init {
        numVehiculos++
    }

    // Estado y metodos de clase con companion object
    companion object {
        var numVehiculos: Int = 0
            private set

        fun random(): Vehiculo {
            val marcas = arrayOf("Ford", "Seat", "Renault", "Fiat")
            val modelos = arrayOf("Focus", "Ibiza", "Clio", "Panda")
            val matriculas = arrayOf("1234ABC", "2345BCD", "3456CDE", "4567DEF")
            val marca = marcas.random()
            val modelo = modelos.random()
            val matricula = matriculas.random()
            return Vehiculo(marca, modelo, matricula)
        }
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vehiculo) return false

        if (marca != other.marca) return false
        if (modelo != other.modelo) return false
        if (matricula != other.matricula) return false

        return true
    }

    override fun hashCode(): Int {
        var result = marca.hashCode()
        result = 31 * result + modelo.hashCode()
        result = 31 * result + matricula.hashCode()
        return result
    }

    override fun toString(): String {
        return "Vehiculo(marca='$marca', modelo='$modelo', matricula='$matricula')"
    }


}