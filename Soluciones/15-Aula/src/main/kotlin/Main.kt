package dev.joseluisgs

import com.github.ajalt.mordant.rendering.TextColors
import dev.joseluisgs.models.Aula
import dev.joseluisgs.models.Ordenador

fun main() {
    println("Hola Aula y Ordenador")
    val aula = Aula("B11", 1, Aula.Titulacion.DAW, 5)
    println(aula)
    println(aula.getAll().contentToString())

    try {
        println(aula.finById(1))
    } catch (e: Exception) {
        println(TextColors.red(e.message.toString()))
    }


    val nuevoOrdenador = Ordenador.random()
    println(nuevoOrdenador)

    for (i in 1..10) {
        try {
            aula.create(Ordenador.random())
        } catch (e: Exception) {
            println(TextColors.red(e.message.toString()))
        } finally {
            println(aula.numOrdenadores)
        }
    }

    println(aula.getAll().contentToString())

    for (i in 1..20) {
        try {
            aula.create(Ordenador.random())
        } catch (e: Exception) {
            println(TextColors.red(e.message.toString()))
        } finally {
            println(aula.numOrdenadores)
        }
    }

    println(aula.getAll().contentToString())

    val updatedOrdenador = nuevoOrdenador.copy(marca = "Marca Actualizada")
    try {
        println(aula.update(2, updatedOrdenador))
    } catch (e: Exception) {
        println(TextColors.red(e.message.toString()))
    }


    println(aula.getAll().contentToString())

    try {
        println(aula.update(9999, updatedOrdenador))
    } catch (e: Exception) {
        println(TextColors.red(e.message.toString()))
    }

    try {
        println(aula.delete(2))
    } catch (e: Exception) {
        println(TextColors.red(e.message.toString()))
    } finally {
        println(aula.numOrdenadores)
        println(aula.getAll().contentToString())
    }

    try {
        println(aula.delete(9999))
    } catch (e: Exception) {
        println(TextColors.red(e.message.toString()))
    }


    val numeroToRemove = 25
    val ordenadores = aula.getAll()
    for (i in 1..numeroToRemove) {
        try {
            aula.delete(ordenadores[i].id)
        } catch (e: Exception) {
            println(TextColors.red(e.message.toString()))
        }
    }

    println("Número de ordenadores: ${aula.numOrdenadores}")
    println(aula.getAll(Aula.Order.DESC).contentToString())
}