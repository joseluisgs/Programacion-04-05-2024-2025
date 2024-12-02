package dev.joseluisgs.models

import dev.joseluisgs.models.Ordenador.Tipo.PORTATIL
import dev.joseluisgs.models.Ordenador.Tipo.SOBREMESA
import java.time.LocalDateTime
import java.util.*

/**
 * Clase que representa un ordenador
 * @property id Identificador del ordenador
 * @property marca Marca del ordenador
 * @property modelo Modelo del ordenador
 * @property tipo Tipo de ordenador
 * @property procesador Procesador del ordenador
 * @property memoriaRam Memoria RAM del ordenador
 * @property almacenamiento Almacenamiento del ordenador
 * @property video Tarjeta de video del ordenador
 * @property createdAt Fecha de creación
 * @property updatedAt Fecha de actualización
 * @property isDeleted Si está eliminado
 */
data class Ordenador(
    val id: Long = NEW_ID,
    val marca: String,
    val modelo: String,
    val tipo: Tipo,
    val procesador: String,
    val memoriaRam: Int,
    val almacenamiento: Int,
    val video: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false
) {
    /**
     * Enumeración de tipos de ordenador
     * @property PORTATIL Ordenador portatil
     * @property SOBREMESA Ordenador de sobremesa
     */
    enum class Tipo {
        PORTATIL, SOBREMESA
    }

    companion object {
        val NEW_ID = 0L

        /**ç
         * Método para generar un ordenador aleatorio
         * @return Ordenador
         */
        fun random(): Ordenador {
            val random = Random()
            val tipo = if (random.nextBoolean()) PORTATIL else SOBREMESA
            return Ordenador(
                marca = "Marca ${random.nextInt(100)}",
                modelo = "Modelo ${random.nextInt(100)}",
                tipo = tipo,
                procesador = "Procesador ${random.nextInt(100)}",
                memoriaRam = (1..64).random(),
                almacenamiento = (128..2048).random(),
                video = "Video ${random.nextInt(100)}"
            )
        }
    }
}
