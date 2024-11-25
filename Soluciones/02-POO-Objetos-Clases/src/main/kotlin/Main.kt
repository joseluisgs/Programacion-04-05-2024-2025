import models.Estudiante
import models.Expediente
import models.Hamburguesa
import models.Persona

fun main(args: Array<String>) {
    var nombre = "Pepe"
    var edad = 25

    println("Hola $nombre, tienes $edad años")

    nombre = "Juan"
    edad = 30

    // Ya he perdido a pepe!

    var nombre2 = "Pepe"
    var edad2 = 25

    val p1 = Persona()
    p1.nombre = "Pepe"
    p1.edad = 25
    println(p1.nombre)
    println(p1.edad)
    println(p1)
    println()

    val p2 = Persona()
    p2.nombre = "Ana"
    p2.edad = 18
    println(p2.nombre)
    println(p2.edad)
    println(p2)
    println()

    p1.saludar()
    p1.despedirse()
    println("Es mayor de edad: " + p1.esMayorDeEdad())
    println()

    p2.saludar()
    p2.despedirse()
    println("Es mayor de edad: " + p2.esMayorDeEdad())
    println()

    val h1 = Hamburguesa()
    h1.nombre = "Big Mac"
    h1.precio = 5.0
    h1.agregarIngrediente(1, "Lechuga")
    h1.agregarIngrediente(2, "Queso")
    h1.agregarIngrediente(3, "Carne")
    h1.agregarIngrediente(4, "Pan")
    h1.agregarIngrediente(5, "Pepinillos")
    h1.agregarIngrediente(6, "Cebolla")
    h1.agregarIngrediente(7, "SalsaEspecial")
    h1.mostrar()
    println()

    p1.comer(h1)
    println()

    val estudiante = Estudiante()
    estudiante.nombre = "Pepe"
    estudiante.edad = 25
    estudiante.expediente.curso = "1º DAW"
    estudiante.expediente.nota = 8.5
    estudiante.expediente.numero = 1234
    estudiante.expediente.email = "pepe@daw.com"
    estudiante.mostrar()
    val nuevoExpediente = Expediente()
    nuevoExpediente.numero = 5678
    nuevoExpediente.email = "nuevo@daw.com"
    nuevoExpediente.curso = "2º DAW"
    nuevoExpediente.nota = 4.0
    estudiante.expediente = nuevoExpediente
    estudiante.mostrar()

    println()


}