package dev.joseluisgs

import dev.joseluisgs.models.*

fun main() {
    println("Hola Herencia")
    //val persona = Persona("Jose", 25) --> No se puede instanciar una clase abstracta
    // persona.presentarse()

    val entrenador = Entrenador("Javier", 50, 20)
    entrenador.presentarse()
    entrenador.entrenar()

    // val jugador = Jugador("Ana", 20, 9)
    // jugador.presentarse()
    // jugador.jugar()

    val portero = Portero("Alicia", 19, 1, 20)
    portero.presentarse()
    portero.jugar()
    portero.parar()

    val jugadorCampo = JugadorCampo("Manuel", 20, 11, 10)
    jugadorCampo.presentarse()
    jugadorCampo.jugar()
    jugadorCampo.marcar()

    val jugadores: Array<Jugador> = arrayOf(jugadorCampo, portero)
    for (jugador in jugadores) {
        jugador.presentarse()
        jugador.jugar()

        when (jugador) {
            is Portero -> jugador.parar()
            is JugadorCampo -> jugador.marcar()
        }
    }

    val personas: Array<Persona> = arrayOf(entrenador, portero, jugadorCampo)
    for (persona in personas) {
        persona.presentarse()
        persona.saludar()
        when (persona) {
            is Entrenador -> persona.entrenar()
            is Portero -> persona.parar()
            is Jugador -> persona.jugar()
        }
    }

    val p1: Persona = Entrenador("Javier", 50, 20)
    p1.presentarse()
    p1.saludar()

    val j1: Jugador = Portero("Alicia", 19, 1, 20)
    j1.presentarse()
    j1.jugar()
    j1.entrenar(10)
}