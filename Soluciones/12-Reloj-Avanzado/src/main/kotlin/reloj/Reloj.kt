package dev.joseluisgs.reloj

import dev.joseluisgs.reloj.Reloj.Formato.HORA_12
import dev.joseluisgs.reloj.Reloj.Formato.HORA_24
import java.time.LocalTime

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
            require(value in 0..23) { "Las horas deben estar entre 0 y 23" }
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
        _numRelojes++
    }

    // Métodos y atributos de clase
    companion object {
        /**
         * Crea un reloj con la hora actual
         * @return Reloj con la hora actual
         */
        fun ahora(): Reloj {
            val ahora = LocalTime.now()
            return Reloj(ahora.hour, ahora.minute, ahora.second)
        }

        /**
         * Crea un reloj con la hora indicada por parámetros (0-23, 0-59, 0-59)
         * @return Reloj con la hora actual
         */
        fun of(horas: Int, minutos: Int, segundos: Int): Reloj {
            return Reloj(horas, minutos, segundos)
        }

        fun from(reloj: Reloj): Reloj {
            return Reloj(reloj.horas, reloj.minutos, reloj.segundos)
        }


        private var _tiempoTranscurrido: Long = 0L
        val tiempoTranscurrido: Long
            get() = _tiempoTranscurrido

        private var _numRelojes: Int = 0
        val numRelojes: Int
            get() = _numRelojes
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
     * @param formatoHora Formato de impresión del reloj, en formato 24 horas o 12 horas (AM/PM)
     * @see FormatoHora
     */
    fun imprimir(formatoHora: Formato = HORA_24) {
        if (formatoHora == HORA_24) {
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
        _tiempoTranscurrido++

    }

    /**
     * Incrementa el tiempo del reloj en un segundo
     * @param segundos Segundos a incrementar
     * @param formatoHora Formato de impresión del reloj, en formato 24 horas o 12 horas (AM/PM)
     * @see FormatoHora
     */
    fun tickTack(segundos: Int = 100, formatoHora: Formato = HORA_24) {
        for (i in 1..segundos) {
            imprimir(formatoHora)
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
        require(hora in 0..23) { "Las horas deben estar entre 0 y 23" }
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

    /**
     * Suma un reloj al actual
     * @param reloj Reloj a sumar
     */
    fun sumar(reloj: Reloj) {
        val nuevosSegundos = (this.segundos + reloj.segundos) % 60
        val nuevosMinutos = this.minutos + (this.segundos + reloj.segundos) / 60
        val nuevasHoras = this.horas + (this.minutos + nuevosMinutos) / 60
        this.horas = nuevasHoras
        this.minutos = nuevosMinutos
        this.segundos = nuevosSegundos
    }

    /**
     * Suma horas al reloj
     * @param horas Horas a sumar
     * @throws IllegalArgumentException si las horas no son positivas
     */
    fun sumarHoras(horas: Int) {
        require(horas >= 0) { "Las horas a sumar deben ser positivas" }
        val nuevasHoras = (this.horas + horas) % 24
        this.horas = nuevasHoras
    }

    /**
     * Suma minutos al reloj
     * @param minutos Minutos a sumar
     * @throws IllegalArgumentException si los minutos no son positivos
     */
    fun sumarMinutos(minutos: Int) {
        require(minutos >= 0) { "Los minutos a sumar deben ser positivos" }
        val nuevasMinutos = (this.minutos + minutos) % 60
        val nuevasHoras = this.horas + (this.minutos + minutos) / 60
        this.horas = nuevasHoras
        this.minutos = nuevasMinutos
    }

    /**
     * Suma segundos al reloj
     * @param segundos Segundos a sumar
     * @throws IllegalArgumentException si los segundos no son positivos
     */
    fun sumarSegundos(segundos: Int) {
        require(segundos >= 0) { "Los segundos a sumar deben ser positivos" }
        val nuevosSegundos = (this.segundos + segundos) % 60
        val nuevosMinutos = this.minutos + (this.segundos + segundos) / 60
        val nuevasHoras = this.horas + (this.minutos + nuevosMinutos) / 60
        this.horas = nuevasHoras
        this.minutos = nuevosMinutos
        this.segundos = nuevosSegundos
    }

    /**
     * Resta un reloj al actual
     */
    fun restar(reloj: Reloj) {
        val nuevosSegundos = (this.segundos - reloj.segundos + 60) % 60
        val nuevosMinutos = this.minutos - (this.segundos - reloj.segundos + 60) / 60
        val nuevasHoras = this.horas - (this.minutos - nuevosMinutos + 60) / 60
        this.horas = nuevasHoras
        this.minutos = nuevosMinutos
        this.segundos = nuevosSegundos
    }

    /**
     * Resta horas al reloj
     * @param horas Horas a restar
     * @throws IllegalArgumentException si las horas no son positivas
     */
    fun restarHoras(horas: Int) {
        require(horas >= 0) { "Las horas a restar deben ser positivas" }
        val nuevasHoras = (this.horas - horas + 24) % 24
        this.horas = nuevasHoras
    }

    /**
     * Resta minutos al reloj
     * @param minutos Minutos a restar
     * @throws IllegalArgumentException si los minutos no son positivos
     */
    fun restarMinutos(minutos: Int) {
        require(minutos >= 0) { "Los minutos a restar deben ser positivos" }
        val nuevasMinutos = (this.minutos - minutos + 60) % 60
        val nuevasHoras = this.horas - (this.minutos - minutos + 60) / 60
        this.horas = nuevasHoras
        this.minutos = nuevasMinutos
    }

    /**
     * Resta segundos al reloj
     * @param segundos Segundos a restar
     * @throws IllegalArgumentException si los segundos no son positivos
     */
    fun restarSegundos(segundos: Int) {
        require(segundos >= 0) { "Los segundos a restar deben ser positivos" }
        val nuevosSegundos = (this.segundos - segundos + 60) % 60
        val nuevosMinutos = this.minutos - (this.segundos - segundos + 60) / 60
        val nuevasHoras = this.horas - (this.minutos - nuevosMinutos + 60) / 60
        this.horas = nuevasHoras
        this.minutos = nuevosMinutos
        this.segundos = nuevosSegundos
    }

    override fun hashCode(): Int {
        var result = horas
        result = 31 * result + minutos
        result = 31 * result + segundos
        return result
    }

    /**
     * Enumerado para el formato de la hora
     * @property HORA_24 Formato de 24 horas
     * @property HORA_12 Formato de 12 horas
     */
    enum class Formato {
        HORA_24, HORA_12
    }

}