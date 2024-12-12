package dev.joseluisgs.models

data class Informe(
    val modulo: String,
    val curso: String,
    val numEstudiantes: Int,
    val numAprobados: Int,
    val numSuspensos: Int,
    val media: Double,
    val porcentajeAprobados: Double,
    val porcentajeSuspensos: Double,
)