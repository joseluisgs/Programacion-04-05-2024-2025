package controllers

import factories.DroidsFactory
import models.Droid
import models.Sw348
import models.Sw421
import models.Sw447
import kotlin.math.min
import kotlin.math.round

/**
 * This class represents a StrikeShip in the game.
 *
 * @property mapSize The size of the game map. Default value is 5.
 * @property numberOfEnemies The number of enemies in the game. Default value is 15.
 * @property timeMax The maximum allowed time for the game in seconds. Default value is 3.
 * @property map The game map.
 * @property enemies The list of enemies in the game.
 * @property leftEnemies The number of enemies left in the game.
 * @property deadEnemies The number of dead enemies in the game.
 * @property numberOfShots The number of shots fired in the game.
 * @property numberOfHits The number of shots that hit an enemy in the game.
 * @property performance The performance of the player in the game.
 */
class StrikeShip(
    private val mapSize: Int = 5,
    private val numberOfEnemies: Int = 15,
    private val timeMax: Int = 3,
) {
    private val map = Array(mapSize) { arrayOfNulls<Droid>(mapSize) }
    private val enemies = Array(numberOfEnemies) { DroidsFactory.random() }
    private val leftEnemies: Int
        get() = numberOfEnemies - deadEnemies
    private val deadEnemies: Int
        get() = getTotalDeadEnemies()
    private var numberOfShots: Int = 0
    private var numberOfHits: Int = 0
    private val performance: Double
        get() = getTotalPerformance()

    /**
     * Simulates the game.
     */
    fun simulate() {
        var time = 0
        placeEnemies()
        printMap()
        do {
            println("Time: $time")
            println("Enemies: $leftEnemies")

            if (time % 300 == 0) {
                println("Enemies are moving")
                placeEnemies()
            }

            Thread.sleep(100)
            time += 100

            // Shot actions!!!!
            val shotValue = giveMeAShot()
            numberOfShots++
            // Posicion del disparo
            val row = (0..<mapSize).random()
            val col = (0..<mapSize).random()
            // hemos dado a un enemigo?
            if (map[row][col] != null) {
                println("You have hit an enemy at ${row + 1}, ${col + 1}")
                numberOfHits++
                // Analizamos segun el tipo de enemigo
                val enemy = map[row][col]!!
                var efectiveDamage: Int = 0
                println("Enemy before atack: $enemy")
                when (enemy) {
                    is Sw348 -> {
                        println("Enemy is defending")
                        efectiveDamage = enemy.defend(shotValue)
                    }

                    is Sw447 -> {
                        println("Enemy is using shield with value: ${enemy.shield}")
                        efectiveDamage = if (enemy.shield > shotValue) 0 else shotValue - enemy.shield
                    }

                    is Sw421 -> {
                        if (!enemy.move()) {
                            println("Enemy is not moving")
                            efectiveDamage = shotValue
                        }
                    }
                }
                enemy.maxEnergy -= efectiveDamage
                println("Efective damage: $efectiveDamage")
                println("Enemy after atack: $enemy")
            } else {
                println("You have missed!")
            }
            printMap()

        } while (leftEnemies > 0 && time < 30 * 1000)

    }

    /**
     * Gives a shot to the enemy.
     *
     * @return The value of the shot.
     */
    private fun giveMeAShot(): Int {
        if ((0..100).random() <= 15) {
            println("You have a critical super shot!")
            return 50
        }
        println("You have a normal shot!")
        return 25
    }

    /**
     * Places the enemies in the map.
     */
    private fun placeEnemies() {
        // Primero borramos los enemigos del mapa, poniendo su pusicion a null
        for (row in 0..<mapSize) {
            for (col in 0..<mapSize) {
                if (map[row][col] != null) {
                    map[row][col] = null
                }
            }
        }
        // Cuantos podemos colocar en el mapa
        // El minimo entre el tamaño del mapa y el numero de enemigos que quedan
        val maxEnemiesToStored = min(mapSize * mapSize, leftEnemies)
        // Colocar maxEnemies vivos en el mapa en una posicion aleatoria
        var storedEnemies = 0
        var enemiesIndex = 0
        while (storedEnemies < maxEnemiesToStored) {
            // Enemies index es el indice del vector de enemigos
            // Deben estar vivos, si no, pasamos al siguiente
            while (enemiesIndex < enemies.size && !enemies[enemiesIndex].isAlive) {
                enemiesIndex++
            }
            var isStored = false
            do {
                val row = (0..<mapSize).random()
                val col = (0..<mapSize).random()
                if (map[row][col] == null) {
                    map[row][col] = enemies[enemiesIndex]
                    storedEnemies++
                    isStored = true
                    enemiesIndex++
                }
            } while (!isStored)
        }
    }

    /**
     * Prints the final report of the simulation.
     */
    fun printReport() {
        println("Map size: $mapSize")
        println("Number of enemies: $numberOfEnemies")
        println("Number of shots: $numberOfShots")
        println("Number of hits: $numberOfHits")
        println("Performance: $performance")
        println("Number of left enemies: $leftEnemies")
        println("Number of dead enemies: $deadEnemies")
        println("Enemies:")
        orderEnemies()
        for ((index, enemy) in enemies.withIndex()) {
            println("Enemy ${index + 1}: $enemy")
        }
        println()
    }

    /**
     * Gets the total number of dead enemies.
     */
    private fun getTotalDeadEnemies(): Int {
        var count = 0
        for (enemy in enemies) {
            if (!enemy.isAlive) {
                count++
            }
        }
        return count
    }

    /**
     * Gets the total performance of the player.
     */
    private fun getTotalPerformance(): Double {
        if (numberOfShots == 0) {
            return 0.0
        }
        // Round to 2 decimals the result
        val result = (numberOfHits.toDouble() / numberOfShots.toDouble()) * 100
        return round(result * 100) / 100
    }

    /**
     * Orders the enemies by maxEnergy in descending order.
     */
    private fun orderEnemies() {
        for (i in 0..<enemies.size - 1) {
            for (j in 0..<enemies.size - i - 1) {
                if (enemies[j].energy < enemies[j + 1].energy) {
                    val temp = enemies[j]
                    enemies[j] = enemies[j + 1]
                    enemies[j + 1] = temp
                }
            }
        }
    }

    /**
     * Prints the map.
     */
    private fun printMap() {
        for (row in map) {
            for (droid in row) {
                if (droid == null) {
                    print("[⚪]")
                } else {
                    print(droid.color)
                }
            }
            println()
        }
    }
}
