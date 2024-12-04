package dev.joseluisgs.views

import com.github.ajalt.mordant.rendering.TextColors
import dev.joseluisgs.controllers.Modulo
import dev.joseluisgs.models.Estudiante
import org.lighthousegames.logging.logging


class View(
    private val modulo: Modulo
) {

    private val logger = logging()


    fun menuOpcionesgestion() {
        println("Bienvenido a la gestión de estudiantes del módulo ${modulo.nombre} de ${modulo.titulacion} de ${modulo.curso}")

        var opcionElegida = -1

        do {
            println("== Menu de opciones ==")
            val opciones = """
                |1. Obtener todos los estudiantes
                |2. Buscar estudiante por ID
                |3. Crear estudiante
                |4. Actualizar estudiante
                |5. Eliminar estudiante
                |6. Resume y estadísticas
                |0. Salir
            """.trimMargin()

            println(opciones)
            print("Ingrese opción: ")
            opcionElegida = readln().toIntOrNull() ?: -1
            when (opcionElegida) {
                1 -> obtenerEstudiantes()
                2 -> buscarEstudiantePorId()
                3 -> crearEstudiante()
                4 -> actualizarEstudiante()
                5 -> eliminarEstudiante()
                6 -> estadisticasEstudiantes()
                0 -> println("Saliendo...")
                else -> println("Opción no válida. Intente de nuevo.")
            }
        } while (opcionElegida != 0)

    }

    fun estadisticasEstudiantes() {
        logger.debug { "Obteniendo estadísticas" }
        println("Obteniendo estadísticas")
        val informe = modulo.getInforme()
        println("Informe:")
        println("Modulo: ${informe.modulo}")
        println("Curso: ${informe.curso}")
        println("Número de estudiantes: ${informe.numEstudiantes}")
        println("Número de aprobados: ${informe.numAprobados}")
        println("Número de suspensos: ${informe.numSuspensos}")
        println("Media de calificaciones: ${informe.media}")
        println("Porcentaje de aprobados: ${informe.porcentajeAprobados}")
        println("Porcentaje de suspensos: ${informe.porcentajeSuspensos}")
    }

    fun eliminarEstudiante() {
        logger.debug { "Eliminando estudiante" }
        println("Eliminando estudiante")

        val id = preguntarId()

        try {
            val estudiante = modulo.delete(id)
            println("Estudiante eliminado:")
            println(estudiante)
        } catch (e: Exception) {
            println(TextColors.red("Error al eliminar estudiante: ${e.message}"))
        }
    }

    private fun actualizarEstudiante() {
        logger.debug { "Actualizando estudiante" }
        println("Actualizando estudiante")

        val id = preguntarId()

        var estudiante: Estudiante? = null
        try {
            estudiante = modulo.findById(id)

            println("Estudiante encontrado:")
            println(estudiante)

        } catch (e: Exception) {
            println(TextColors.red("Estudiante no encontrado: ${e.message}"))
            return
        }

        println("Nuevos datos del estudiantes:")

        val nuevoNombre = actualizarNombre()

        val nuevosApellidos = actaulizarApellidos()

        val nuevaCalificacion = actualizarCalificacion()

        val nuevoEstudiante = estudiante.copy(
            nombre = if (nuevoNombre.isNotEmpty()) nuevoNombre else estudiante.nombre,
            apellidos = if (nuevosApellidos.isNotEmpty()) nuevosApellidos else estudiante.apellidos,
            calificacion = if (nuevaCalificacion != -1.0) nuevaCalificacion else estudiante.calificacion
        )

        try {
            val res = modulo.update(id, nuevoEstudiante)
            println("Estudiante actualizado:")
            println(res)
        } catch (e: Exception) {
            println(TextColors.red("Error al actualizar estudiante: ${e.message}"))
        }

    }

    private fun actualizarCalificacion(): Double {
        logger.debug { "Actualizando calificación" }
        var opcionCalificacion = "s"
        var nuevaCalificacion = -1.0
        do {
            print("¿Desea cambiar la calificación? (s/n): ")
            opcionCalificacion = readln().lowercase()
        } while (opcionCalificacion != "s" && opcionCalificacion != "n")
        if (opcionCalificacion == "s") {
            nuevaCalificacion = preguntarCalificacion()
        }
        return nuevaCalificacion
    }

    private fun actaulizarApellidos(): String {
        logger.debug { "Actualizando apellidos" }
        var opcionApellidos = "s"
        var nuevosApellidos = ""
        do {
            print("¿Desea cambiar los apellidos? (s/n): ")
            opcionApellidos = readln().lowercase()
        } while (opcionApellidos != "s" && opcionApellidos != "n")
        if (opcionApellidos == "s") {
            nuevosApellidos = preguntarApellidos()
        }
        return nuevosApellidos
    }

    private fun actualizarNombre(): String {
        logger.debug { "Actualizando nombre" }
        var opcionNombre = "s"
        var nuevoNombre = ""
        do {
            print("¿Desea cambiar el nombre? (s/n): ")
            opcionNombre = readln().lowercase()
        } while (opcionNombre != "s" && opcionNombre != "n")
        if (opcionNombre == "s") {
            nuevoNombre = preguntarNombre()
        }
        return nuevoNombre
    }

    private fun crearEstudiante() {
        logger.debug { "Creando estudiante" }
        println("Creando estudiante")
        // Nombre
        val nombre = preguntarNombre()

        // Apellidos
        val apellidos = preguntarApellidos()

        // Calificación
        val calificacion = preguntarCalificacion()

        val estudiante = Estudiante(
            nombre = nombre,
            apellidos = apellidos,
            calificacion = calificacion
        )
        try {
            val res = modulo.create(estudiante)
            println("Estudiante creado:")
            println(res)
        } catch (e: Exception) {
            println(TextColors.red("Error al crear estudiante: ${e.message}"))
        }
    }

    private fun preguntarCalificacion(): Double {
        var calificacion = -1.0
        do {
            print("Ingrese calificación del estudiante: ")
            calificacion = readln().toDoubleOrNull() ?: -1.0
            if (calificacion == -1.0 || calificacion < 0 || calificacion > 10) {
                println("Debe ingresar una calificación válida")
            }
        } while (calificacion == -1.0 || calificacion < 0 || calificacion > 10)
        return calificacion
    }

    private fun preguntarApellidos(): String {
        var apellidos = ""
        do {
            print("Ingrese apellidos del estudiante: ")
            apellidos = readln()
            if (apellidos.isEmpty()) {
                println("Debe ingresar un apellido")
            }
        } while (apellidos.isEmpty())
        return apellidos
    }

    private fun preguntarNombre(): String {
        var nombre = ""
        do {
            print("Ingrese nombre del estudiante: ")
            nombre = readln()
            if (nombre.isEmpty()) {
                println("Debe ingresar un nombre")
            }
        } while (nombre.isEmpty())
        return nombre
    }

    private fun buscarEstudiantePorId() {
        logger.debug { "Buscando estudiante por ID" }
        println("Buscando estudiante por ID")

        val idABuscar = preguntarId()

        try {
            val estudiante = modulo.findById(idABuscar)
            println("Estudiante encontrado:")
            println(estudiante)
        } catch (e: Exception) {
            println(TextColors.red("Estudiante no encontrado: ${e.message}"))
        }
    }

    private fun preguntarId(): Int {
        var idABuscar: Int
        // Parte de entrada de datos
        do {
            print("Ingrese ID del estudiante: ")
            idABuscar = readln().toIntOrNull() ?: 0
            if (idABuscar == 0) {
                println("Debe ingresar un ID válido mayor a 0")
            }
        } while (idABuscar <= 0)
        return idABuscar
    }

    private fun obtenerEstudiantes() {
        logger.debug { "Obteniendo todos los estudiantes" }
        println("Obteniendo todos los estudiantes")
        val res = modulo.getAll()
        if (res.isEmpty()) {
            println("No hay estudiantes en el módulo")
            return
        } else {
            println("Estudiantes en el módulo:")
            for (estudiante in res) {
                println(estudiante)
            }
        }
    }
}