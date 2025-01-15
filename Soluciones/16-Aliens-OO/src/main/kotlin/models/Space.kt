package models

import kotlin.random.Random

/**
 * Class that represents a Space with Aliens.
 * @property configuration Configuration of the simulation.
 * @property cuadrante Space with the Aliens.
 * @property finalAliens Final number of Aliens.
 * @property finalLives Final number of lives.
 * @property finalTime Final time.
 * @constructor Creates a Space with the default values.
 * @see Configuration
 */
class Space(val configuration: Configuration) {
    private var cuadrante: Array<Array<Alien?>> = createSpace()
    private var finalAliens: Int = configuration.numAliens
    private var finalLives: Int = configuration.maxLives
    private var finalTime: Int = configuration.maxTime

    private fun createSpace(): Array<Array<Alien?>> {
        val space = Array(configuration.spaceSize) { arrayOfNulls<Alien>(configuration.spaceSize) }
        repeat(configuration.numAliens) {
            // No podemos poner dos aliens en la misma posición
            var isStored = false
            do {
                val x = Random.nextInt(configuration.spaceSize)
                val y = Random.nextInt(configuration.spaceSize)
                // Si la posición está vacía, la ocupamos
                if (space[x][y] == null) {
                    space[x][y] = Alien(configuration.aliensMaxLives)
                    isStored = true
                }
            } while (!isStored)
        }
        return space
    }

    /**
     * Function that simulates the battle against the Aliens.
     */
    fun simulation() {
        var time = 1
        var lives = configuration.maxLives
        var aliens = configuration.numAliens

        do {
            println()
            println("Tiempo: $time")
            println("Vidas: $lives")
            println("Aliens restantes: $aliens")
            printSpace()

            // otras cosas
            if (aimAndFire()) {
                aliens -= 1
            }

            // Condiciones tiempo
            if (time % configuration.timeAtack == 0) {
                if (alienAtack()) {
                    lives -= 1
                    println("Los aliens han atacado!")
                    println("Vidas restantes: $lives")
                } else {
                    println("Los aliens han fallado al atacar!")
                }
            }

            // Cada 2 segundos cambiamos de posición los alines
            if (time % 2 == 0) {
                // Los aliens se mueven aleatoramente (version cutre para aprobar)
                // Doble buffer, origen --> destino
                val cuadranteBuffer = copyCuadrante(cuadrante)
                moveAliens(cuadranteBuffer)
                println("Los aliens se han movido!")
                // Doble buffer, destino --> origen
                cuadrante = copyCuadrante(cuadranteBuffer)
            }

            Thread.sleep(configuration.pauseTime)
            time += 1

        } while (time <= configuration.maxTime && lives > 0 && aliens > 0)
        finalAliens = aliens
        finalLives = lives
        finalTime = time
    }

    /**
     * Function that prints the final report of the simulation.
     */
    fun report() {
        println()
        printSpace()
        println("Tiempo: $finalTime")
        println("Vidas: $finalLives")
        println("Aliens restantes: $finalAliens")
        if (finalAliens == 0) {
            println("Has aniquilado a todos los aliens!")
        } else {
            println("Hay aliens vivos que regresarán a por ti!")
        }
        if (finalLives == 0) {
            println("Has muerto en esta batalla!")
        } else {
            println("Has sobrevivido, y vives para luchar otro día!")
        }
        println()
    }

    /**
     * Function that moves the Aliens to adjacent positions.
     * @param spaceBuffer Space with the Aliens.
     */
    private fun moveAliens(spaceBuffer: Array<Array<Alien?>>) {
        // Recorremos el espacion
        for (i in cuadrante.indices) {
            for (j in cuadrante[i].indices) {
                if (cuadrante[i][j] != null) {
                    val alien = cuadrante[i][j] as Alien
                    // println("Alien se desplaza desde [${i + 1},${j + 1}]")
                    moveAlienToANewPosition(alien, spaceBuffer, i, j)
                }
            }
        }
    }

    /**
     * Function that moves an Alien to an adjacent position.
     * @param alien Alien to move.
     * @param spaceBuffer Space with the Aliens.
     * @param fil Row of the Alien.
     * @param col Column of the Alien.
     */
    private fun moveAlienToANewPosition(alien: Alien, spaceBuffer: Array<Array<Alien?>>, fil: Int, col: Int) {
        // Obtenemos las posiciones adyacentes
        var isStored = false
        var newFil: Int
        var newCol: Int
        var intentos = 0
        do {
            newFil = (-1..1).random() + fil
            newCol = (-1..1).random() + col
            // Cuidado que es spaceBuffer porque comparamos con la nueva posición
            // si no se daría el caso de que el alien se mueve a una posición
            // que ya está ocupada por otro alien
            if (isValidPosition(newFil, newCol) && spaceBuffer[newFil][newCol] == null) {
                spaceBuffer[fil][col] = null
                spaceBuffer[newFil][newCol] = alien
                isStored = true
            }
            intentos++
        } while (!isStored && intentos++ < configuration.maxTriesToMove)
        if (!isStored) {
            println("El alien en la posición [${fil + 1},${col + 1}] no se ha podido mover por estar bloqueado!")
        } else {
            println("Alien se desplaza desde [${fil + 1},${col + 1}] a [${newFil + 1},${newCol + 1}]")
        }
    }

    /**
     * Function that checks if a position is valid.
     * @param fil Row of the position.
     * @param col Column of the position.
     * @return True if the position is valid, false otherwise.
     */
    private fun isValidPosition(fil: Int, col: Int): Boolean {
        return fil in 0..<configuration.spaceSize && col in 0..<configuration.spaceSize
    }

    /**
     * Function that copies a Space.
     * @param origen Space to copy.
     * @return The copy of the Space.
     */
    private fun copyCuadrante(origen: Array<Array<Alien?>>): Array<Array<Alien?>> {
        val copy = Array(configuration.spaceSize) { arrayOfNulls<Alien>(configuration.spaceSize) }
        for (i in origen.indices) {
            for (j in origen[i].indices) {
                copy[i][j] = origen[i][j]
            }
        }
        return copy
    }

    /**
     * Function that prints the Space.
     */
    private fun printSpace() {
        for (row in cuadrante) {
            for (cell in row) {
                if (cell != null) {
                    print("[A]")
                } else {
                    print("[ ]")
                }
            }
            println()
        }
    }

    /**
     * Function that aims and fires to an Alien.
     * @param spaceBuffer Space with the Aliens.
     * @return True if the Alien has been killed, false otherwise.
     */
    private fun aimAndFire(): Boolean {
        println("Apuntando...")
        val x = Random.nextInt(configuration.spaceSize)
        val y = Random.nextInt(configuration.spaceSize)
        if (cuadrante[x][y] == null) {
            println("Has disparado a la posición [${x + 1},${y + 1}] y y es una posición vacía!")
            return false
        }
        return if (Random.nextInt(100) < configuration.probAtack) {
            println("Has disparado a la posición [${x + 1},${y + 1}] y has acertado!")
            cuadrante[x][y]!!.maxLives -= 1
            if (cuadrante[x][y]?.maxLives == 0) {
                println("**** Has matado al alien en la posición [${x + 1},${y + 1}]! ****")
                cuadrante[x][y] = null
                true
            } else {
                println("El alien en la posición [${x + 1},${y + 1}] le quedan ${cuadrante[x][y]?.maxLives} vidas!")
                false
            }
        } else {
            println("Has disparado a la posición [${x + 1},${y + 1}] y has fallado!")
            false
        }
    }

    /**
     * Function that aims and fires to an Alien.
     * @param spaceBuffer Space with the Aliens.
     * @return True if the Alien has been killed, false otherwise.
     */
    private fun alienAtack(): Boolean {
        return Random.nextInt(100) < configuration.probAtack
    }
}