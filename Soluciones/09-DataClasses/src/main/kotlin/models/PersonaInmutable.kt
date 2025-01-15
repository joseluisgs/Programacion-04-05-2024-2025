package dev.joseluisgs.models

data class PersonaInmutable(
    val nombre: String,
    val telefono: String = "N/A",
    val edad: Int,
)
