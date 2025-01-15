package dev.joseluisgs

import dev.joseluisgs.models.*

fun main() {
    println("Un estudiante que es persona")
    val estudiante = Estudiante("Jose", "1DAW")
    estudiante.saluda()
    estudiante.estudiar()
    println()

    println("Un guitar hero que es persona, musico y guitarrista")
    val guitarrista = GuitarHero("Eva")
    guitarrista.saluda()
    guitarrista.tocar()
    println()

    println("Un corista que es persona, musico y vocalista")
    val corista = Corista("Antonio")
    corista.saluda()
    corista.cantar()
    corista.tocar()
    println()

    println("Un cantante que es persona, musico y vocalista y guitarrista")
    val vocalista = Cantante("Maria")
    vocalista.saluda()
    vocalista.cantar()
    vocalista.tocar()
    println()

    // Polimorfismo
    println("Polimorfismo")
    val p1: Persona = Estudiante("Jose", "1DAW")
    val p2: Persona = GuitarHero("Eva")
    val p3: Musico = GuitarHero("Eva")

    // Array solo de musicos
    val musicos: Array<Musico> = arrayOf(
        GuitarHero("Eva"),
        Corista("Antonio"),
        Cantante("Maria")
    )

    for (musico in musicos) {
        musico.tocar()

        /*when (musico) {
            is GuitarHero -> musico.tocar()
            is Corista -> musico.cantar()
            is Cantante -> musico.cantar()
        }*/

        if (musico is Cantante) {
            musico.cantar()
        }
    }

    // Existe polimorfismo usando interfaces
    val i1: Vocalista = Cantante("Maria")
    val i2: Guitarrista = Cantante("Maria")
    val i3: Musico = Cantante("Maria")
    val i4: Persona = Cantante("Maria")

    // Array solo de guitarristas
    val guitarristas: Array<Guitarrista> = arrayOf(
        GuitarHero("Eva"),
        Cantante("Maria")
    )

    // Array solo de vocalistas
    val vocalistas: Array<Vocalista> = arrayOf(
        Corista("Antonio"),
        Cantante("Maria")
    )

    for (musico in musicos) {

        musico.interpretar()

        if (musico is Vocalista) {
            musico.cantar()
        }
        if (musico is Guitarrista) {
            musico.tocar()
        }
        if (musico is Cantante) {
            musico.tocar()
            musico.cantar()
            musico.saluda()
        }
    }

    for (guitarrista in guitarristas) {
        guitarrista.tocar()
    }

    for (vocalista in vocalistas) {
        vocalista.cantar()
    }


    mostrarInfoPersona(i3)

    tocarConGuitarrista(i2)
    tocarConGuitarrista(i4 as Guitarrista)

    val g1 = crearGuiarrista("Eva")
    g1.tocar()

    // OJO con esto!!!!
    //val g2: Cantante = crearGuiarrista("Eva") as Cantante
    //g2.tocar()
    //g2.cantar()

    val personas: Array<Persona> = arrayOf(
        Estudiante("Jose", "1DAW"),
        GuitarHero("Eva"),
        Corista("Antonio"),
        Cantante("Maria")
    )

    for (persona in personas) {
        persona.saluda()

        /*if (persona is Musico || persona is Estudiante) {
            (persona as Interpretador).interpretar()
        }*/

        if (persona is Interpretador) {
            persona.interpretar()
        }
    }

    val interpreteadores: Array<Interpretador> = arrayOf(
        Estudiante("Jose", "1DAW"),
        GuitarHero("Eva"),
        Corista("Antonio"),
        Cantante("Maria")
    )

    for (interpreteador in interpreteadores) {

        interpreteador.interpretar()

        if (interpreteador is Persona) {
            interpreteador.saluda()
        }

        if (interpreteador is Musico) {
            interpreteador.tocar()
        }

        if (interpreteador is Vocalista) {
            interpreteador.cantar()
        }

    }

    val c1: Vocalista = Corista("Maria")
    val m1: Musico = Cantante("Maria")
    val p4: Persona = Cantante("Maria")

}


fun tocarConGuitarrista(i: Guitarrista) {
    i.tocar()
}

fun mostrarInfoPersona(p: Persona) {
    println("Nombre: ${p.nombre}")
    p.saluda()
}

fun crearGuiarrista(nombre: String): Guitarrista {
    return GuitarHero(nombre)
}
