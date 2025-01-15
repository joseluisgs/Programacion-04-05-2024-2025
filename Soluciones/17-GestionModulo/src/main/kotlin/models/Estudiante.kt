package dev.joseluisgs.models

import java.time.LocalDateTime

data class Estudiante(
    val id: Int = NEW_ID,
    val nombre: String,
    val apellidos: String,
    val calificacion: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val isActive: Boolean = true,
) {
    companion object {
        const val NEW_ID = -1
        private var nextId = 1
        fun getNextId(): Int {
            return nextId++
        }
    }

    val isAprobado: Boolean
        get() = calificacion >= 5.0
}
