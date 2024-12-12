package dev.joseluisgs

import dev.joseluisgs.reloj.Reloj

fun main() {
    val reloj = Reloj(13, 30, 0)
    println(reloj)
    println("Formato 24 horas:")
    reloj.imprimir()
    println("Formato 12 horas:")
    reloj.imprimir(false)
    println()

    reloj.horas = 23
    reloj.minutos = 59
    reloj.segundos = 55

    reloj.tickTack(100, true)

}