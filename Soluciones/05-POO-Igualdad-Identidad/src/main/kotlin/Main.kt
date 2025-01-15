import models.persona.Persona

fun main(args: Array<String>) {
    val p1 = Persona("Juan", 20)
    p1.presentarse()
    val p2 = Persona("Juan", 20)
    p2.presentarse()
    val p3 = p1

    if (p1 == p2) {
        println("Son iguales")
    } else {
        println("Son diferentes")
    }

    if (p1 === p2) {
        println("Son el mismo objeto")
    } else {
        println("Son diferentes objetos")
    }

    if (p1 == p3) {
        println("Son iguales")
    } else {
        println("Son diferentes")
    }

    if (p1 === p3) {
        println("Son el mismo objeto")
    } else {
        println("Son diferentes objetos")
    }

    println(p1.hashCode())
    println(p2.hashCode())

    if (p1.hashCode() == p2.hashCode()) {
        println("Son iguales")
    } else {
        println("Son diferentes")
    }
}