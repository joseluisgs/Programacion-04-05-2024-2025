package dev.joseluisgs

import dev.joseluisgs.models.composicion.Coche
import dev.joseluisgs.models.composicion.MotorDiesel
import dev.joseluisgs.models.composicion.MotorElectrico
import dev.joseluisgs.models.composicion.MotorProtonico

fun main() {
    val motorDiesel = MotorDiesel()
    val motorElectrico = MotorElectrico()

    val coche = Coche("Seat", "Ibiza", "1234ABC", motorDiesel)
    val cochecito = Coche("Renault", "Zoe", "5678DEF", motorElectrico)
    coche.arrancar()
    cochecito.arrancar()
    if (coche.motor is MotorDiesel) {
        (coche.motor as MotorDiesel).repostar()
    }
    if (cochecito.motor is MotorElectrico) {
        (cochecito.motor as MotorElectrico).cargarBateria()
    }

    cochecito.motor = motorDiesel
    (cochecito.motor as MotorDiesel).repostar()
    cochecito.parar()

    cochecito.motor = MotorProtonico()
    cochecito.arrancar()
    (cochecito.motor as MotorProtonico).explosionar()
    cochecito.parar()

}