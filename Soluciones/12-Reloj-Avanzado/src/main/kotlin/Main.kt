package dev.joseluisgs

import dev.joseluisgs.reloj.Reloj

fun main() {
    val reloj = Reloj(13, 10, 20)
    println(reloj)
    println("Formato 24 horas:")
    reloj.imprimir()
    println("Formato 12 horas:")
    reloj.imprimir(Reloj.Formato.HORA_12)
    println()

    reloj.horas = 23
    reloj.minutos = 59
    reloj.segundos = 55

    reloj.tickTack(10, Reloj.Formato.HORA_24)
    val reloj2 = Reloj.ahora()
    println(reloj2)
    val reloj3 = Reloj.of(23, 59, 59)
    reloj3.tickTack(5, Reloj.Formato.HORA_12)
    val reloj4 = Reloj.from(reloj2)
    println(reloj4)
    println(reloj4 == reloj2)
    reloj4.tickTack(5, Reloj.Formato.HORA_24)
    println(Reloj.numRelojes)
    println(Reloj.tiempoTranscurrido)

}