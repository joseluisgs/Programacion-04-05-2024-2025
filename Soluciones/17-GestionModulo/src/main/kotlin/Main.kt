package dev.joseluisgs

import dev.joseluisgs.controllers.Modulo
import dev.joseluisgs.views.View
import org.lighthousegames.logging.logging

private val logger = logging()

fun main() {

    val modulo = Modulo(
        id = Modulo.getNextId(),
        nombre = "Programación",
        curso = Modulo.Curso.PRIMERO,
        titulacion = Modulo.Titulacion.DAM
    )

    val view = View(modulo)

    view.menuOpcionesgestion()
}

