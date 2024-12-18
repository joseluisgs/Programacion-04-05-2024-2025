package dev.joseluisgs

import dev.joseluisgs.models.Alumno
import dev.joseluisgs.models.Persona
import dev.joseluisgs.models.Profesor

fun main() {
    println("Hola herencia")
    val persona = Persona("Ana", 20)
    persona.curso = "DAW"
    println(persona.saludar())
    println(persona.saltar())
    println(persona)
    val alumno = Alumno("Jose", 30, 5.0)
    alumno.curso = "DAW"
    println(alumno.saludar())
    println(alumno.presentar())
    println(alumno.saltar())
    println(alumno)
    val profesor = Profesor("Isabel", 40, "Bases de Datos")
    profesor.curso = "DAW"
    println(profesor.saludar())
    println(profesor.darClase())
    println(profesor.saltar())
    println(profesor)

    // Los objetos siempre son instancias de una clase, pero si heredan son
    // instancias de la clase padre y de la clase hija
    // y todos hereadamos de Any

    // Any es la clase padre de todas las clases

    if (persona is Persona) {
        println("Es una persona")
    } else {
        println("No es una persona")
    }

    if (persona is Any) {
        println("Es un Any")
    } else {
        println("No es un Any")
    }

    if (persona is Alumno) {
        println("Es un alumno")
    } else {
        println("No es un alumno")
    }

    if (persona is Profesor) {
        println("Es un profesor")
    } else {
        println("No es un profesor")
    }

    if (alumno is Persona) {
        println("Es una persona")
    } else {
        println("No es una persona")
    }

    if (alumno is Any) {
        println("Es un Any")
    } else {
        println("No es un Any")
    }

    if (alumno is Alumno) {
        println("Es un alumno")
    } else {
        println("No es un alumno")
    }

    /*if (alumno is Profesor) {
        println("Es un profesor")
    } else {
        println("No es un profesor")
    }*/

    if (profesor is Persona) {
        println("Es una persona")
    } else {
        println("No es una persona")
    }

    if (profesor is Any) {
        println("Es un Any")
    } else {
        println("No es un Any")
    }

    /* if (profesor is Alumno) {
         println("Es un alumno")
     } else {
         println("No es un alumno")
     }*/

    if (profesor is Profesor) {
        println("Es un profesor")
    } else {
        println("No es un profesor")
    }
}