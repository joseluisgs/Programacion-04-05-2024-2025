package models.personas.privada

class PersonaPrivadaRequire {
    private var nombre: String = ""
    private var edad: Int = 0

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
    }
}