package dev.joseluisgs

import dev.joseluisgs.models.Persona
import dev.joseluisgs.models.Portero
import dev.joseluisgs.models.RolDefensaImpl
import dev.joseluisgs.models.RolEntrenadorImpl

fun main() {
    val rolRolEntrenadorImpl = RolEntrenadorImpl()
    val p1: Persona = Persona("Jose", rolRolEntrenadorImpl)
    println(p1)
    (p1.rol as RolEntrenadorImpl).entrenar()

    val rolRolDefensaImpl = RolDefensaImpl(2)
    val p2: Persona = Persona("Luis", rolRolDefensaImpl)
    println(p2)
    (p2.rol as RolDefensaImpl).defender()

    p1.rol = rolRolDefensaImpl
    p2.rol = rolRolEntrenadorImpl

    println(p1)
    println(p2)
    (p1.rol as RolDefensaImpl).defender()
    (p2.rol as RolEntrenadorImpl).entrenar()

    val portero = Portero("Pepe", 13)
    println(portero)
    portero.role.parar()
    portero.role.entrenar()


}