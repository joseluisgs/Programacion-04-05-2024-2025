package dev.joseluisgs

import dev.joseluisgs.models.*

fun main() {
    val c1 = CafeteraCapsulasConLeche()
    val c2: ICafeteraCapsulas = CafeteraCapsulas()
    val c3: ICapsulas = CafeteraCapsulasConLeche()
    val c4: ICapsulas = CafeteraCapsulas()

    val calelentadores: Array<ICalentador> = arrayOf(CafeteraCapsulasConLeche(), CafeteraCapsulas())
    val capsulas: Array<ICapsulas> = arrayOf(c1, c2, c3, c4)
    calentarCafeteras(c1)
    calentarCafeteras(c2)
    insertarCapsulas(c1)
    insertarCapsulas(c2)
    insertarCapsulas(c3)
    insertarCapsulas(c4)
}

fun calentarCafeteras(caletador: ICalentador) {
    caletador.calentar()
}

fun insertarCapsulas(capsulas: ICapsulas) {
    capsulas.insertarCapsula()
}

fun interrogaCafetera(cafetera: Any) {
    when (cafetera) {
        is CafeteraCapsulasConLeche -> {
            println("Es una cafetera de capsulas con leche")
        }

        is CafeteraCapsulas -> {
            println("Es una cafetera de capsulas")
        }

        is ICapsulas -> {
            println("Es una cafetera de capsulas y ese es su comportamiento")
        }

        is ICalentador -> {
            println("Es un calentador")
        }

        else -> {
            println("No se que es")
        }
    }
}