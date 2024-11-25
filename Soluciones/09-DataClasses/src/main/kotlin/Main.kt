package dev.joseluisgs

import dev.joseluisgs.models.Person
import dev.joseluisgs.models.Persona
import dev.joseluisgs.models.PersonaInmutable

fun main() {
    val p1 = Person("John Doe", 30)
    println(p1)
    val p2 = Persona("John Doe", 30)
    println(p2)
    val p3 = Persona("John Doe", 30)
    println(p2 == p3)

    p3.nombre = "Jane Doe"
    println(p3)

    val p4 = PersonaInmutable("Jane Doe", edad = -1)
    println(p4)

    val p5 = p4.copy(edad = 31)
    println(p5)
    val p6 = p4.copy(nombre = "John Doe")
    println(p6)
    val p7 = p6.copy(nombre = "Jim Doe", edad = 33)
    println(p7)

    val nombre = p7.nombre
    val edad = p7.edad
    println("Nombre: $nombre, Edad: $edad")

    val (nombre2, _, edad2) = p7
    println("Nombre: $nombre2, Edad: $edad2")

    val p8 = p7.copy(telefono = "123456789")
    println(p8)

    // En est ecaso si es más rápido hacer p8.telefono
    val (_, telefono, _) = p8
    println("Telefono: $telefono")

}