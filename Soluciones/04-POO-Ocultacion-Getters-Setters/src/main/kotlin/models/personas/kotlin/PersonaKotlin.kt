package models.personas.kotlin

// En kotlin los Getters y Setters se declaran en la clase
// Si una propiedad es var tiene el getter y el setter (lectura y escritura)
// Si una propiedad es val tiene el getter pero no tiene el setter (lect)

class PersonaKotlin(
    val nombre: String,
    private var _edad: Int
) {

    var apellidos: String = ""
        // Solo personalizamos el get o el set si es necesario
        get() = field.uppercase() // Cada vez que se llama a este getter se pasa a mayusculas
        set(value) {
            require(value.isNotEmpty()) { "Debes ingresar un apellido que nos ea vacío" }
            field = value.lowercase() // Cada vez que se llama a este setter se pasa a minusculas
            println("Apellidos: $field")
        }

    var edad
        get() = _edad
        set(value) {
            require(value >= 0) { "Debes ingresar una edad mayor o igual a 0" }
            _edad = value
            println("Edad: $value")
        }


    init {
        check(nombre.isNotEmpty()) { "El nombre no puede estar vacio" }
        check(edad >= 0) { "La edad no puede ser negativa" }
    }

    fun mostrar() {
        println("Nombre: $nombre, Edad: $edad, Apellidos: $apellidos")
    }
}