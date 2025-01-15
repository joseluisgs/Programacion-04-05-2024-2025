package models.personas.privada

class PersonaPrivada {
    private var nombre: String = ""
    private var edad: Int = 0

    // Getters and Setters
    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    fun getNombre(): String {
        return nombre
    }

    fun setEdad(edad: Int) {
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