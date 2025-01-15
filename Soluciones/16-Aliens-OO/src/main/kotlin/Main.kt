package dev.joseluisgs

import models.Configuration
import models.Space

/**
 * Main function of the program that creates a Space and starts the simulation.
 */
fun main(args: Array<String>) {
    println("La guerra contra los Aliens ha comenzado!")
    println()
    val space = Space(Configuration())
    space.simulation()
    println("La guerra contra los Aliens ha terminado!")
    println()
    space.report()
}





