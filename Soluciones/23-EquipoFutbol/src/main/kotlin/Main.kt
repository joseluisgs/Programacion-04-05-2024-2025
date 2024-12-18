package dev.joseluisgs

import dev.joseluisgs.models.*
import java.time.LocalDate

fun main() {
    println("Hola Equipo")
    val entrenador = Entrenador(
        id = Persona.nextId(),
        nombre = "Pepe",
        fechaNacimiento = LocalDate.parse("1992-01-01"),
        especialidad = "Fútbol",
        experiencia = 10
    )

    val portero = Portero(
        id = Persona.nextId(),
        nombre = "Juani",
        fechaNacimiento = LocalDate.parse("2000-02-14"),
        dorsal = 1
    )

    val jugador1 = Jugador(
        id = Persona.nextId(),
        nombre = "Luisa",
        fechaNacimiento = LocalDate.parse("1995-02-14"),
        dorsal = 2,
        posicion = JugadorCampo.Posicion.DEFENSA
    )

    val jugador2 = Jugador(
        id = Persona.nextId(),
        nombre = "Ana",
        fechaNacimiento = LocalDate.parse("1998-02-14"),
        dorsal = 3,
        posicion = JugadorCampo.Posicion.CENTROCAMPISTA
    )

    val jugador3 = Jugador(
        id = Persona.nextId(),
        nombre = "Maria",
        fechaNacimiento = LocalDate.parse("1997-02-14"),
        dorsal = 4,
        posicion = JugadorCampo.Posicion.DELANTERO
    )

    println(entrenador)
    println(portero)
    println(jugador1)
    println(jugador2)

    println()

    entrenador.entrenar()
    portero.entrenar()
    jugador1.entrenar()
    jugador2.entrenar()
    jugador3.entrenar()

    println()

    portero.parar()

    println()
    portero.jugar()
    jugador1.jugar()
    jugador2.jugar()
    jugador3.jugar()

    println()
    jugador1.chutar()
    jugador2.chutar()
    jugador3.chutar()

    println()
    portero.hidratarse()
    jugador1.hidratarse()
    jugador2.hidratarse()
    jugador3.hidratarse()

    // Cuidado con estas cosas (que es lo que se llama polimorfismo)

    val persona1: Persona = portero
    val persona2: Persona = Jugador(
        id = Persona.nextId(),
        nombre = "Jugador02",
        fechaNacimiento = LocalDate.parse("1992-01-01"),
        dorsal = 1,
        posicion = JugadorCampo.Posicion.PORTERO
    )
    persona2.entrenar()
    println()
    val persona3: JugadorCampo = Portero(
        id = Persona.nextId(),
        nombre = "Portero03",
        fechaNacimiento = LocalDate.parse("1992-01-01"),
        dorsal = 1
    )
    persona3.entrenar()
    persona3.hidratarse()
    (persona3 as Portero).parar()
    // (persona3 as Jugador).chutar() // Exception: ClassCastException

    val equipo: Array<Persona> =
        arrayOf(entrenador, portero, jugador1, jugador2, jugador3, persona1, persona2, persona3)
    println()
    for (persona in equipo) {
        println(persona)
        persona.entrenar()
    }

    // si queremos cosas especificas, liate con los tipos
    println()
    for (persona in equipo) {
        if (persona is Jugador) {
            persona.chutar()
        }
        if (persona is Portero) {
            persona.parar()
        }
    }

    println()
    for (persona in equipo) {
        dimeQueEres(persona)
    }

}

fun dimeQueEres(persona: Persona) {
    /*when (persona) {
        is Entrenador -> println("${persona.nombre}: Soy un Entrenador")
        is Jugador -> println("${persona.nombre}: Soy un Jugador")
        is Portero -> println("${persona.nombre}: Soy un Portero")
        else -> println("${persona.nombre}: Soy una Persona")
    }*/
    if (persona is Entrenador) {
        println("${persona.nombre}: Soy un Entrenador")
    }
    if (persona is Jugador) {
        println("${persona.nombre}: Soy un Jugador")
    }
    if (persona is Portero) {
        println("${persona.nombre}: Soy un Portero")
    }
    if (persona is JugadorCampo) {
        println("${persona.nombre}: Soy un Jugador de Campo")
    }
    println("${persona.nombre}: Soy una Persona")

}
