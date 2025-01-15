fun main(args: Array<String>) {
    // Fabrica de vehículos

    val v1 = Vehiculo("Ford", "Focus", "1234ABC")
    println(v1)
    val v2 = Vehiculo("Ford", "Focus", "1234ABC")
    println(v2)

    println(Vehiculo.numVehiculos)

    val v3 = Vehiculo.random()
    println(v3)



    println(Vehiculo.numVehiculos)
}