package dev.joseluisgs

import dev.joseluisgs.models.Animal
import dev.joseluisgs.models.Color
import dev.joseluisgs.models.TipoVehiculo
import dev.joseluisgs.models.Vehiculo
import dev.joseluisgs.models.Vehiculo as VehiculoTriste
import dev.joseluisgs.otro.Vehiculo as OtroVehiculo

typealias VehiculoContemporaneo = Vehiculo

fun main() {
    val v1 = Vehiculo("1234ABC", "Ford", "Focus", precio = 12000.0)
    println(v1)
    val v2 = Vehiculo("5678DEF", "Renault", "Clio", Color.NARANJA, 10000.0, TipoVehiculo.COCHE)
    println(v2)

    // Sacar todos los colores
    for (color in Color.entries) {
        println(color)
    }

    for (i in 0..<Color.entries.size) {
        println(Color.entries[i])
    }

    val color = Color.AZUL
    println(color.toString())
    println(color.name)
    println(color.ordinal)

    //val color2 = Color.valueOf("VIOLETA")
    //println(color2)
    //println(color2.ordinal)
    //println(color2.name)

    for (animal in Animal.entries) {
        println("${animal.ordinal}: El animal ${animal.name} hace ${animal.sonido} y tiene ${animal.patas} patas")
    }

    val animal = Animal.valueOf("PERRO")
    println(animal)

    val animal2 = Animal.GATO
    println(animal2)

    val otroVehiculo = OtroVehiculo("Ford", "Focus")
    println(otroVehiculo)

    val v3 = VehiculoTriste("XYZ123", "Ford", "Focus", Color.ROJO, 15000.0, TipoVehiculo.COCHE)

    val v4 = VehiculoContemporaneo("XYZ123", "Ford", "Focus", Color.ROJO, 15000.0, TipoVehiculo.COCHE)

    val v5 = dev.joseluisgs.otro.Vehiculo("Ford", "Focus")
}