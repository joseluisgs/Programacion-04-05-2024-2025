package models.personas.constructor

/**
 * Clase PersonaPrivadaRestricciones
 * @author joseluisgs
 * @version 1.0
 */
class PersonaConConstructorRestricciones(
    private var nombre: String = "",
    private var edad: Int = 0
) {

    private var soyPrivada = "No me ves"

    init {
        check(nombre.isNotEmpty()) { "El nombre no puede ser vacio" }
        check(edad >= 0) { "La edad no puede ser negativa" }

        // Equivale a
        // if (nombre.isEmpty()) throw IllegalStateException("El nombre no puede ser vacio")
        // if (edad < 0) throw IllegalStateException("La edad no puede ser negativa")
    }

    // Getters and Setters
    fun setNombre(nombre: String) {
        require(nombre.isNotEmpty()) { "El nombre no puede ser vacio" }
        this.nombre = nombre
    }

    fun getNombre(): String {
        return nombre
    }

    /**
     * Setea la edad de la persona
     * @param edad la edad de la persona en años
     * @throws IllegalArgumentException si la edad es menor a 0
     */
    fun setEdad(edad: Int) {
        require(edad >= 0) { "La edad no puede ser negativa" }
        this.edad = edad
    }

    fun getEdad(): Int {
        return edad
    }


    fun mostrar() {
        println(nombre)
        println(edad)
        println(soyPrivada)
    }

    private fun cambiarSoyPrivada() {
        soyPrivada = "No me ves y me han cambiado"
    }
}