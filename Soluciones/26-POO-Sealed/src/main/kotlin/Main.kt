package dev.joseluisgs

import dev.joseluisgs.models.banda.TipoMusico
import dev.joseluisgs.models.banda.normal.CantanteA
import dev.joseluisgs.models.banda.normal.GuitarristaA
import dev.joseluisgs.models.banda.normal.MusicoAbstract
import dev.joseluisgs.models.banda.sealed.BajistaB
import dev.joseluisgs.models.banda.sealed.CantanteB
import dev.joseluisgs.models.banda.sealed.GuitarristaB
import dev.joseluisgs.models.banda.sealed.MusicoSealed

fun main() {
    val cantanteA = CantanteA("CantanteA")
    cantanteA.presentar()
    cantanteA.tocar()
    cantanteA.cantar()

    val guitarrista = GuitarristaA("GuitarristaA")
    guitarrista.presentar()
    guitarrista.tocar()
    guitarrista.afinar()

    tocandoConMusicoA(cantanteA)
    tocandoConMusicoA(guitarrista)

    val cantanteB = CantanteB("CantanteB")
    cantanteB.presentar()
    cantanteB.tocar()
    cantanteB.cantar()

    val guitarristaB = GuitarristaB("GuitarristaB")
    guitarristaB.presentar()
    guitarristaB.tocar()
    guitarristaB.afinar()

    tocandoConMusicoB(cantanteB)
    tocandoConMusicoB(guitarristaB)

    val tipoMusico: TipoMusico = TipoMusico.CANTANTE

    tocandoConMusicoC(tipoMusico)

}

fun tocandoConMusicoC(tipoMusico: TipoMusico) {
    when (tipoMusico) {
        TipoMusico.CANTANTE -> {
            println("Cantando")
        }

        TipoMusico.GUITARRISTA -> {
            println("Tocando guitarra")
        }

        TipoMusico.BAJISTA -> {
            println("Tocando bajo")
        }
    }
}


fun tocandoConMusicoA(musico: MusicoAbstract) {
    when (musico) {
        is CantanteA -> {
            musico.cantar()
        }

        is GuitarristaA -> {
            musico.afinar()
        }
        // Bajista???? si se te olvida que??
    }
}

fun tocandoConMusicoB(musico: MusicoSealed) {
    when (musico) {
        is CantanteB -> {
            musico.cantar()
        }

        is GuitarristaB -> {
            musico.afinar()
        }

        is BajistaB -> {
            musico.afinar()
        }
    }
}