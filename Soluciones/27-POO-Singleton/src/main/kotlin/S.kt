package dev.joseluisgs

object S {
    private var count = 0

    init {
        println("Creando instancia S")
        count++
    }

    override fun toString(): String {
        return "S: $count"
    }
}