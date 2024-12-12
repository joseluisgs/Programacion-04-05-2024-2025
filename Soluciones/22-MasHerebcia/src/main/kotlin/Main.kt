package dev.joseluisgs

import dev.joseluisgs.herencia.Estudiante
import dev.joseluisgs.herencia.Persona
import dev.joseluisgs.herencia.Profesor

fun main() {
    println("Hello World!")

    val p1 = Profesor(1, "Pepe", 10)
    p1.presentarse()
    p1.enseñar()
    p1.saludar()
    println(p1)

    val e1 = Estudiante(2, "Juan", 8.8)
    e1.presentarse()
    e1.estudiar()
    e1.saludar()
    println(e1)

    //val pe = Persona(3, "Maria")
    //pe.presentarse()
    //pe.saludar()
    //println(pe)

    if (p1 is Profesor && p1 is Persona) {
        println("Es un profesor y una persona")
    }

}