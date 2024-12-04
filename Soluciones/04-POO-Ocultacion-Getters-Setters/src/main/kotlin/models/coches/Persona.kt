package models.coches

import java.time.LocalDateTime

class Persona(
    val dni: String,
    private var _nombre: String,
    private var _edad: Int,
    val vehiculo: Vehiculo,
    private val createdAt: LocalDateTime = LocalDateTime.now()
) {
    var nombre: String = ""
        get() = _nombre
        set(value) {
            require(value.isNotEmpty()) { "Debes ingresar un nombre que nos ea vacío" }
            field = value
        }

    var edad
        get() = _edad
        set(value) {
            require(value >= 18) { "Debes ingresar una edad mayor o igual a 18" }
            _edad = value
        }

    init {
        check(nombre.isNotEmpty()) { "El nombre no puede estar vacio" }
        check(edad >= 0) { "La edad no puede ser negativa" }
    }

    fun mostrar() {
        println("Nombre: $nombre, Edad: $edad, DNI: $dni, Creado: $createdAt")
        vehiculo.mostrar()
    }
}