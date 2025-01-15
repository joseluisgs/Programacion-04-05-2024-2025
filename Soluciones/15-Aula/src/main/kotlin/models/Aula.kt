package dev.joseluisgs.models

import dev.joseluisgs.models.Aula.Titulacion.*
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

private val logger = logging()

/**
 * Clase que representa un aula
 * @property id Identificador del aula
 * @property curso Curso al que pertenece el aula
 * @property titulacion Titulación del aula
 * @property maxOrdenadores Máximo de ordenadores que puede tener el aula
 * @property numOrdenadores Número de ordenadores que tiene el aula
 */
class Aula(
    val id: String,
    val curso: Int,
    val titulacion: Titulacion,
    val maxOrdenadores: Int = 10
) {

    private var nextId = 1L
    private var _numOrdenadores = 0
    private val fragDegree = 0.75
    val numOrdenadores: Int get() = _numOrdenadores

    private var ordenadores = Array<Ordenador?>(maxOrdenadores) { null }

    /**
     * Enumeración de titulaciones
     * @property DAM Desarrollo de Aplicaciones Multiplataforma
     * @property DAW Desarrollo de Aplicaciones Web
     * @property ASIR Administración de Sistemas Informáticos en Red
     * @property SMR Sistemas Microinformáticos y Redes
     */
    enum class Titulacion {
        DAM, DAW, ASIR, SMR
    }

    enum class Order {
        ASC, DESC
    }

    override fun toString(): String {
        return "Aula(id='$id', curso=$curso, titulacion=$titulacion)"
    }

    /**
     * Obtiene todos los ordenadores del aula
     * @return Array de ordenadores
     */
    fun getAll(order: Order = Order.ASC): Array<Ordenador> {
        logger.debug { "Obteniendo todos los ordenadores del aula $id" }
        var ordenadores = getOrdenadoresSinNulos()
        ordenadores = if (order == Order.DESC) {
            ordenacionDescendente(ordenadores)
        } else {
            ordenacionAscendente(ordenadores)
        }
        return ordenadores
    }

    /**
     * Ordenada por el método de la burbuja de forma ascendente
     * @param ordenadores Array de ordenadores a ordenar
     * @return Array de ordenadores ordenado de forma ascendente
     */
    private fun ordenacionAscendente(ordenadores: Array<Ordenador>): Array<Ordenador> {
        logger.debug { "Ordenando los ordenadores de forma ascendente" }
        for (i in 0 until ordenadores.size - 1) {
            for (j in 0 until ordenadores.size - 1 - i) {
                if (ordenadores[j].id > ordenadores[j + 1].id) {
                    val temp = ordenadores[j]
                    ordenadores[j] = ordenadores[j + 1]
                    ordenadores[j + 1] = temp
                }
            }
        }
        return ordenadores
    }

    private fun ordenacionDescendente(ordenadores: Array<Ordenador>): Array<Ordenador> {
        logger.debug { "Ordenando los ordenadores de forma descendente" }
        for (i in 0 until ordenadores.size - 1) {
            for (j in 0 until ordenadores.size - 1 - i) {
                if (ordenadores[j].id < ordenadores[j + 1].id) {
                    val temp = ordenadores[j]
                    ordenadores[j] = ordenadores[j + 1]
                    ordenadores[j + 1] = temp
                }
            }
        }
        return ordenadores
    }

    /**
     * Obtiene un array sin nulos de los ordenadores del aula
     * @return Array de ordenadores sin nulos
     */
    private fun getOrdenadoresSinNulos(): Array<Ordenador> {
        logger.debug { "Obteniendo los ordenadores sin nulos del aula $id" }
        val ordenadoresSinNulos = Array<Ordenador?>(_numOrdenadores) { null }
        var index = 0
        for (ordenador in ordenadores) {
            if (ordenador != null) {
                ordenadoresSinNulos[index] = ordenador
                index++
            }
        }
        return ordenadoresSinNulos as Array<Ordenador>
    }

    /**
     * Encuentra un ordenador por su id
     * @param id Identificador del ordenador
     * @return Ordenador encontrado o null si no se encuentra
     */
    fun finById(id: Long): Ordenador {
        logger.debug { "Buscando el ordenador con id $id en el aula $id" }
        for (ordenador in ordenadores) {
            /*if (ordenador != null && ordenador.id == id) {
                return ordenador
            }*/
            // El distinto de null está implicito con el safe call
            if (ordenador?.id == id) {
                return ordenador
            }
        }
        logger.error { "No se ha encontrado el ordenador con id $id en el aula $id" }
        throw Exception("No se ha encontrado el ordenador con id $id en el aula $id")
    }

    fun create(ordenador: Ordenador): Ordenador {
        logger.debug { "Creando un nuevo ordenador en el aula $id" }
        // Validar los datos del ordenador
        validateOrdenador(ordenador)
        // Comprobar si hay espacio
        checkSpace()
        // Generar un id y una fecha de creación y actualización
        val timeStamp = LocalDateTime.now()
        val newOrdenador =
            ordenador.copy(id = nextId++, createdAt = timeStamp, updatedAt = timeStamp)
        // Buscar la primera posición vacía y añadir el ordenador
        val index = primeraPosicionVacia()
        ordenadores[index] = newOrdenador
        _numOrdenadores++
        logger.debug { "Ordenador creado: $newOrdenador" }
        return newOrdenador

    }

    private fun primeraPosicionVacia(): Int {
        logger.debug { "Buscando la primera posición vacía en el aula $id" }
        for (index in ordenadores.indices) {
            if (ordenadores[index] == null) {
                return index
            }
        }
        throw IllegalStateException("No se ha encontrado una posición vacía en el aula")

    }

    /**
     * Comprueba si hay espacio en el aula para un nuevo ordenador
     * @see MAX_ORDENADORES
     * @see ordenadores
     * @see redimensionarArray
     */
    private fun checkSpace() {
        logger.debug { "Comprobando si hay espacio en el aula $id" }
        if (numOrdenadores == ordenadores.size) {
            //throw IllegalStateException("No hay espacio en el aula para más ordenadores")
            redimensionarArray()
        }
    }

    /**
     * Redimensiona el array de ordenadores del aula
     * Añadiendo MAX_ORDENADORES más
     * @see MAX_ORDENADORES
     * @see ordenadores
     */
    private fun redimensionarArray() {
        logger.debug { "Redimensionando el array de ordenadores del aula $id" }
        val nuevoArray = Array<Ordenador?>(numOrdenadores + maxOrdenadores) { null }
        logger.debug { "Nuevo tamaño del array de ordenadores: ${nuevoArray.size}" }
        // Copiamos los elementos del array antiguo al nuevo si no son nulos
        var index = 0
        for (ordenador in ordenadores) {
            if (ordenador != null) {
                nuevoArray[index] = ordenador
                index++
            }
        }
        // Hacemos el swap de arrays
        ordenadores = nuevoArray
    }

    /**
     * Valida los datos de un ordenador
     * @param ordenador Ordenador a validar
     */
    private fun validateOrdenador(ordenador: Ordenador) {
        logger.debug { "Validando los datos del ordenador: $ordenador" }
        require(ordenador.marca.isNotBlank()) { "La marca del ordenador no puede estar vacía" }
        require(ordenador.modelo.isNotBlank()) { "El modelo del ordenador no puede estar vacío" }
        require(ordenador.procesador.isNotBlank()) { "El procesador del ordenador no puede estar vacío" }
        require(ordenador.memoriaRam > 0) { "La memoria RAM del ordenador debe ser mayor que 0" }
        require(ordenador.almacenamiento > 0) { "El disco duro del ordenador debe ser mayor que 0" }
        require(ordenador.video.isNotBlank()) { "La tarjeta de video del ordenador no puede estar vacía" }
    }

    /**
     * Actualiza un ordenador del aula
     * @param id Identificador del ordenador
     * @param ordenador Datos del ordenador a actualizar
     * @return Ordenador actualizado o null si no se ha encontrado
     */
    fun update(id: Long, ordenador: Ordenador): Ordenador {
        logger.debug { "Actualizando el ordenador con id $id en el aula ${this.id}" }
        val index = findIndexbyOrdenadorId(id)
        // validar los datos del ordenador
        validateOrdenador(ordenador)
        // Actualizar el ordenador
        val timeStamp = LocalDateTime.now()
        val updatedOrdenador = ordenador.copy(id = id, updatedAt = timeStamp)
        ordenadores[index] = updatedOrdenador
        logger.debug { "Ordenador actualizado: $updatedOrdenador" }
        return updatedOrdenador
    }

    /**
     * Busca la posición de un ordenador en el array de ordenadores en función de su id
     * @param id Identificador del ordenador
     * @return Posición del ordenador en el array de ordenadores o -1 si no se ha encontrado
     * @see ordenadores
     * @see Ordenador.id
     */
    private fun findIndexbyOrdenadorId(id: Long): Int {
        logger.debug { "Buscando la posición del ordenador con id $id en el aula ${this.id}" }
        for (index in ordenadores.indices) {
            if (ordenadores[index]?.id == id) {
                return index
            }
        }
        logger.error { "No se ha encontrado el ordenador con id $id en el aula" }
        throw Exception("No se ha encontrado el ordenador con id $id en el aula")
    }


    /**
     * Elimina un ordenador del aula
     * @param id Identificador del ordenador
     * @return Ordenador eliminado o null si no se ha encontrado
     */
    fun delete(id: Long): Ordenador {
        logger.debug { "Eliminando el ordenador con id $id en el aula ${this.id}" }
        val index = findIndexbyOrdenadorId(id)
        val deletedOrdenador = ordenadores[index]!!
        ordenadores[index] = null
        _numOrdenadores--

        analizarFragmentacion()

        logger.debug { "Ordenador eliminado: $deletedOrdenador" }
        return deletedOrdenador.copy(isDeleted = true)
    }

    private fun analizarFragmentacion() {
        logger.debug { "Analizando la fragmentación del aula ${this.id}" }
        // Analizar el grado de ocupación del array es menor del fragDegree redimensionar
        if (numOrdenadores < ordenadores.size * fragDegree) {
            redimensionarArray()
        }
    }
}