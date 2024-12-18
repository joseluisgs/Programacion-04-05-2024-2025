package dev.joseluisgs.factories

import dev.joseluisgs.models.*
import java.time.LocalDate

class PersonaFactoy {

    companion object {
        fun getEntrenador(
            nombre: String,
            apellidos: String,
            fechaNacimiento: LocalDate,
            especialidad: String,
            experiencia: Int = 0
        ): Entrenador {
            return Entrenador(Persona.nextId(), nombre, fechaNacimiento, especialidad, experiencia)
        }

        fun getJugador(
            nombre: String,
            fechaNacimiento: LocalDate,
            dorsal: Int,
            tipo: JugadorCampo.Posicion,
        ): JugadorCampo {
            return when (tipo) {
                JugadorCampo.Posicion.PORTERO -> Portero(
                    Persona.nextId(),
                    nombre,
                    fechaNacimiento,
                    dorsal,
                )

                else -> Jugador(
                    Persona.nextId(),
                    nombre,
                    fechaNacimiento,
                    dorsal,
                    tipo
                )
            }
        }

        fun getJugadorRandom(): JugadorCampo {
            // 10% son porteros, 30% son defensas, 30% son centrocampistas y 20% son delanteros
            val tipo = when ((0..100).random()) {
                in 0..10 -> JugadorCampo.Posicion.PORTERO
                in 11..40 -> JugadorCampo.Posicion.DEFENSA
                in 41..70 -> JugadorCampo.Posicion.CENTROCAMPISTA
                else -> JugadorCampo.Posicion.DELANTERO
            }
            val random = (1..99).random()
            return getJugador(
                "Jugador $random",
                LocalDate.now(),
                random,
                tipo
            )
        }

        fun getPersonaRandom(): Persona {
            val random = (1..99).random()
            return when ((0..100).random()) {
                in 0..50 -> getEntrenador("Entrenador $random", "Apellido $random", LocalDate.now(), "Fútbol", 10)
                else -> getJugadorRandom()
            }
        }

        fun getPortero(
            nombre: String,
            fechaNacimiento: LocalDate,
            dorsal: Int,
        ): Portero {
            return Portero(Persona.nextId(), nombre, fechaNacimiento, dorsal)
        }

        fun getDefensa(
            nombre: String,
            fechaNacimiento: LocalDate,
            dorsal: Int,
        ): Jugador {
            return Jugador(Persona.nextId(), nombre, fechaNacimiento, dorsal, JugadorCampo.Posicion.DEFENSA)
        }
    }
}