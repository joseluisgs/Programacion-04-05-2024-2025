package models.personas.privada

class PersonaPrivadaRestricciones {
    private var nombre: String = ""
    private var edad: Int = 0

    // Getters and Setters
    fun setNombre(nombre: String) {
        if (nombre.isNotEmpty()) {
            this.nombre = nombre
        } else {
            throw IllegalArgumentException("El nombre no puede ser vacio")
        }
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
        if (edad >= 0) {
            this.edad = edad
        } else {
            throw IllegalArgumentException("La edad no puede ser negativa")
        }
    }

    fun getEdad(): Int {
        return edad
    }


    fun mostrar() {
        println(nombre)
        println(edad)
    }
}