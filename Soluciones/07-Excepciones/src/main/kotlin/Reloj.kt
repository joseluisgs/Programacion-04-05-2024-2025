package dev.joseluisgs

/**
 * Clase que representa un reloj
 * @property horas Horas del reloj (0-23)
 * @property minutos Minutos del reloj (0-59)
 * @property segundos Segundos del reloj (0-59)
 * @throws IllegalArgumentException si los valores no están en el rango adecuado
 * @constructor Crea un reloj con las horas, minutos y segundos indicados (0-23, 0-59, 0-59)
 */
class Reloj {
    var horas: Int = 0
        set(value) {
            require(value in 0..24) { "Las horas deben estar entre 0 y 23" }
            field = value
        }
    var minutos: Int = 0
        set(value) {
            require(value in 0..59) { "Los minutos deben estar entre 0 y 59" }
            field = value
        }
    var segundos: Int = 0
        set(value) {
            require(value in 0..59) { "Los segundos deben estar entre 0 y 59" }
            field = value
        }

    /**
     * Constructor de la clase
     * @param horas Horas del reloj (0-23)
     * @param minutos Minutos del reloj (0-59)
     * @param segundos Segundos del reloj (0-59)
     * @throws IllegalArgumentException si los valores no están en el rango adecuado
     */
    constructor(horas: Int, minutos: Int, segundos: Int) {
        this.horas = horas
        this.minutos = minutos
        this.segundos = segundos
    }

    override fun toString(): String {
        // Formateamos la salida para que todo tenga al menos un 0 si es menor que 10
        return "${formatoNumero(horas)}:${formatoNumero(minutos)}:${formatoNumero(segundos)}"
    }

    /**
     * Formatea un número para que tenga al menos dos dígitos
     * @param value Número a formatear
     * @return Número formateado
     */
    private fun formatoNumero(value: Int): String {
        return value.toString().padStart(2, '0')
        //return if (value < 10) "0$value" else value.toString()
    }

    /**
     * Imprime la hora del reloj
     * @param formato24 Formato de impresión del reloj, true formato 24 horas, false formato 12 horas (AM/PM)
     */
    fun imprimir(formato24: Boolean = true) {
        if (formato24) {
            println(this)
        } else {
            val ampm = if (horas < 12) "AM" else "PM"
            val horas12 = if (horas > 12) horas - 12 else horas
            println("${formatoNumero(horas12)}:${formatoNumero(minutos)}:${formatoNumero(segundos)} $ampm")
        }
    }

    /**
     * Incrementa el tiempo del reloj en un segundo
     */
    private fun tick() {
        // este codigo da error por que no se puede modificar una propiedad si no esta en el rango adecuado
        // Es lo que estás haciendo con el ++
        /*
        segundos++
        if (segundos == 60) {
            segundos = 0
            minutos++
            if (minutos == 60) {
                minutos = 0
                horas++
                if (horas == 24) {
                    horas = 0
                }
            }
        }
        */
        // Todo parece que se complica por que no se puede modificar una propiedad si no esta en el rango adecuado
        // Pero es más seguro y más claro
        val nuevosSegundos = segundos + 1
        if (nuevosSegundos != 60) {
            segundos = nuevosSegundos
        } else {
            segundos = 0
            val nuevosMinutos = minutos + 1
            if (nuevosMinutos != 60) {
                minutos = nuevosMinutos
            } else {
                minutos = 0
                val nuevasHoras = horas + 1
                horas = if (nuevasHoras != 24) nuevasHoras else 0
            }

        }

    }

    /**
     * Incrementa el tiempo del reloj en un segundo
     * @param segundos Segundos a incrementar
     * @param formato24 Formato de impresión del reloj, true formato 24 horas, false formato 12 horas (AM/PM)
     */
    fun tickTack(segundos: Int = 100, formato24: Boolean = true) {
        for (i in 1..segundos) {
            imprimir(formato24)
            tick()
            Thread.sleep(1000)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Reloj) return false

        if (horas != other.horas) return false
        if (minutos != other.minutos) return false
        if (segundos != other.segundos) return false

        return true
    }

    /**
     * Comprueba si el reloj coincide con la hora de la alarma
     * @param hora Hora de la alarma (0-23)
     * @param minuto Minuto de la alarma (0-59)
     * @param segundo Segundo de la alarma (0-59)
     * @throws IllegalArgumentException si los valores no están en el rango adecuado
     */
    fun alarma(hora: Int, minuto: Int, segundo: Int) {
        require(hora in 0..24) { "Las horas deben estar entre 0 y 23" }
        require(minuto in 0..59) { "Los minutos deben estar entre 0 y 59" }
        require(segundo in 0..59) { "Los segundos deben estar entre 0 y 59" }
        if (horas == hora && minutos == minuto && segundos == segundo) {
            println("¡¡¡ALARMA!!!")
        }
    }

    /**
     * Comprueba si el reloj coincide con la hora de la alarma
     * @param reloj Reloj de la alarma
     */
    fun alarma(reloj: Reloj) {
        if (this == reloj) {
            println("¡¡¡ALARMA!!!")
        }
    }

    override fun hashCode(): Int {
        var result = horas
        result = 31 * result + minutos
        result = 31 * result + segundos
        return result
    }

}