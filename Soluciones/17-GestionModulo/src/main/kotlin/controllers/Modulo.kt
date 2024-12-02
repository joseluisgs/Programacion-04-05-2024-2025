package dev.joseluisgs.controllers

import dev.joseluisgs.models.Estudiante
import dev.joseluisgs.models.Informe
import dev.joseluisgs.utils.Utils
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

const val MAX_ESTUDIANTES_POR_CURSO = 30

class Modulo(
    val id: Int = NEW_ID,
    val nombre: String,
    val curso: Curso,
    val titulacion: Titulacion
) {
    private val logger = logging()
    private val estudiantes: Array<Estudiante?> = arrayOfNulls(MAX_ESTUDIANTES_POR_CURSO)
    private var totalEstudiantes: Int = 0

    companion object {
        const val NEW_ID = -1
        private var nextId = 1
        fun getNextId(): Int {
            return nextId++
        }
    }

    // CRUD
    fun getAll(): Array<Estudiante> {
        logger.debug { "Getting all estudiantes for modulo: $nombre" }
        return getEstudaintesSinNull()
    }

    private fun getEstudaintesSinNull(): Array<Estudiante> {
        logger.debug { "Getting non-null estudiantes for modulo: $nombre" }
        val estudiantesSinNull = arrayOfNulls<Estudiante>(totalEstudiantes)
        var i = 0
        for (estudiante in estudiantes) {
            if (estudiante != null) {
                estudiantesSinNull[i++] = estudiante
            }
        }
        return estudiantesSinNull as Array<Estudiante>
    }

    fun findById(id: Int): Estudiante {
        logger.debug { "Getting estudiante with id: $id for modulo: $nombre" }
        for (estudiante in estudiantes) {
            if (estudiante?.id == id) {
                return estudiante
            }
        }
        logger.error { "Estudiante with id: $id not found for modulo: $nombre" }
        throw Exception("No se ha encontrado el estudiante con ID: $id")
    }

    fun create(estudiante: Estudiante): Estudiante {
        logger.debug { "Creating estudiante: $estudiante for modulo: $nombre" }
        /*  if (totalEstudiantes >= MAX_ESTUDIANTES_POR_CURSO) {
              logger.error { "Max number of estudiantes reached for modulo: $nombre" }
              throw Exception("Máximo número de estudiantes alcanzado")
          }*/
        val index = findEmptyIndex()
        val timeStamp = LocalDateTime.now()
        val nuevoEstudiante = estudiante.copy(
            id = Estudiante.getNextId(),
            createdAt = timeStamp,
            updatedAt = timeStamp
        )
        estudiantes[index] = nuevoEstudiante
        totalEstudiantes++
        return nuevoEstudiante
    }

    fun update(id: Int, estudiante: Estudiante): Estudiante {
        logger.debug { "Updating estudiante with id: $id for modulo: $nombre" }
        for (i in estudiantes.indices) {
            if (estudiantes[i]?.id == id) {
                val estudianteActualizado = estudiante.copy(
                    id = id,
                    createdAt = estudiantes[i]!!.createdAt,
                    updatedAt = LocalDateTime.now()
                )
                estudiantes[i] = estudianteActualizado
                return estudianteActualizado
            }
        }
        logger.error { "Estudiante with id: $id not found for modulo: $nombre" }
        throw Exception("No se ha encontrado el estudiante con ID: $id")
    }

    fun delete(id: Int): Estudiante {
        logger.debug { "Deleting estudiante with id: $id for modulo: $nombre" }
        for (i in estudiantes.indices) {
            if (estudiantes[i]?.id == id) {
                val estudianteBorrado = estudiantes[i]!!.copy(
                    id = id,
                    updatedAt = LocalDateTime.now(),
                    isActive = false
                )
                estudiantes[i] = null
                totalEstudiantes--
                return estudianteBorrado
            }
        }
        logger.error { "Estudiante with id: $id not found for modulo: $nombre" }
        throw Exception("No se ha encontrado el estudiante con ID: $id")
    }

    fun getInforme(): Informe {
        logger.debug { "Calculating estadisticas for modulo: $nombre" }
        val nombreModulo = nombre
        val cursoModulo = curso.name
        val numEstudiantes = totalEstudiantes
        val numAprobados = getNumAprobados()
        val numSuspensos = totalEstudiantes - numAprobados
        val media = getMediaCalificacion()
        val porcentajeAprobados = (numAprobados.toDouble() / totalEstudiantes) * 100
        val porcentajeSuspensos = 100 - porcentajeAprobados
        return Informe(
            nombreModulo,
            cursoModulo,
            numEstudiantes,
            numAprobados,
            numSuspensos,
            Utils.rounded(media, 2),
            Utils.rounded(porcentajeAprobados, 2),
            Utils.rounded(porcentajeSuspensos, 2)
        )
    }

    private fun getMediaCalificacion(): Double {
        logger.debug { "Calculating media calificacion for modulo: $nombre" }
        // early return
        if (totalEstudiantes == 0) {
            return 0.0
        }
        var sumaCalificaciones = 0.0
        for (estudiante in estudiantes) {
            sumaCalificaciones += estudiante?.calificacion ?: 0.0
        }
        return sumaCalificaciones / totalEstudiantes
    }

    private fun getNumAprobados(): Int {
        logger.debug { "Calculating number of aprobados for modulo: $nombre" }
        var numAprobados = 0
        for (estudiante in estudiantes) {
            if (estudiante?.isAprobado == true) {
                numAprobados++
            }
        }
        return numAprobados
    }

    private fun findEmptyIndex(): Int {
        logger.debug { "Finding empty index for modulo: $nombre" }
        for (i in estudiantes.indices) {
            if (estudiantes[i] == null) {
                return i
            }
        }
        logger.error { "No empty index found for modulo: $nombre" }
        throw Exception("El módulo está lleno, no hay huecos libre en la lista de clase")
    }

    enum class Curso {
        PRIMERO, SEGUNDO
    }

    enum class Titulacion {
        DAM, DAW
    }
}


