package dev.joseluisgs.models

data class Vehiculo(
    val matricula: String,
    val marca: String,
    val modelo: String,
    val color: Color = Color.BLANCO,
    val precio: Double,
    val tipo: TipoVehiculo = TipoVehiculo.COCHE
)
