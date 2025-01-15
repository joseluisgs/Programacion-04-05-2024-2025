package dev.joseluisgs.models

// Interfaces permiten la herencia múltiple, por composición
interface ICafeteraCapsulas : ICalentador, ICapsulas {
    fun prepararCafetera()
    fun limpiarCafetera()
}