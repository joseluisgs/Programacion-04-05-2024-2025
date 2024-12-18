package dev.joseluisgs

import dev.joseluisgs.models.Entrenador
import dev.joseluisgs.models.Jugadora
import dev.joseluisgs.models.Persona

fun main() {
    println("Selección Española Futbol Femenino")

    val persona = Persona("Persona", 25)
    persona.presentarse()
    println(persona)

    val entrenador = Entrenador("Entrenador", 25, 2)
    entrenador.presentarse()
    entrenador.entrenar()
    println(entrenador)

    val jugadora = Jugadora("Jugadora", 25, 2, 4, Jugadora.Posicion.CENTROCAMPISTA)
    jugadora.presentarse()
    jugadora.entrenar()
    jugadora.jugar()
    println(jugadora)

    val equipo: Array<Persona> = arrayOf(persona, entrenador, jugadora)

    for (persona in equipo) {
        persona.presentarse()
        when (persona) {
            is Entrenador -> persona.entrenar()
            is Jugadora -> persona.jugar()
        }
    }

    val persona2: Persona = Entrenador("Entrenador", 25, 2)
    persona2.presentarse()
    val persona3: Persona = Jugadora("Jugadora", 25, 2, 4, Jugadora.Posicion.CENTROCAMPISTA)
    persona3.presentarse()


    val persona4: Entrenador = persona2 as Entrenador
    persona4.entrenar()
    val persona5: Jugadora = persona3 as Jugadora
    persona5.jugar()
    // val persona6: Jugadora = persona2 as Jugadora

    persona3.jugar()

    val superNumber: Any = 12
    val number: Number = 12.0
    val number2: Number = 12
    val number3: Number = 12L
    val number4: Number = 12.0f

    val double = number as Double
    val int = number2 as Int // number.toInt()
    val long = number3 as Long
    val float = number4 as Float
    val otherInt = superNumber as Int
}
