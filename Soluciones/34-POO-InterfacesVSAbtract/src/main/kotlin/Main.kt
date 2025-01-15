package dev.joseluisgs

import dev.joseluisgs.models.CantanteA
import dev.joseluisgs.models.CantanteC
import dev.joseluisgs.models.CantanteI

fun main() {
    val cantanteA = CantanteA()
    cantanteA.saludar()
    cantanteA.cantar()
    println("Experiencia: ${cantanteA.experiencia}")

    val cantanteI = CantanteI()
    cantanteI.saludar()
    cantanteI.cantar()
    println("Experiencia: ${cantanteI.experiencia}")

    val cantanteC = CantanteC()
    cantanteC.saludar()
    cantanteC.cantar()
    println("Experiencia: ${cantanteC.experiencia}")
}