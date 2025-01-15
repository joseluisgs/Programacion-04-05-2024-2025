package models

import kotlin.system.exitProcess

/**
 * Represents the configuration settings for a game.
 *
 * @property mapSize The size of the game map.
 * @property numberOfEnemies The number of enemies in the game.
 * @property time The time limit for the game.
 */
class Configuation private constructor(val mapSize: Int = 5, val numberOfEnemies: Int = 15, val time: Int = 3) {

    // Metodo de clase
    companion object {

        /**
         * Creates a Configuration object from the provided command-line arguments.
         *
         * @param args The command-line arguments as an array of strings.
         *
         * @return The Configuration object based on the provided arguments.
         */
        fun fromArgs(args: Array<String>): Configuation {
            if (args.size != 3) {
                showErrorMessage()
            }

            val mapSize = args[0].trim().toIntOrNull() ?: -1
            val numberOfEnemies = args[1].trim().toIntOrNull() ?: -1
            val time = args[2].trim().toIntOrNull() ?: -1

            if (mapSize !in (5..9) || numberOfEnemies !in (5..30) || time !in (1..3)) {
                showErrorMessage()
            }

            return Configuation(mapSize, numberOfEnemies, time)
        }

        /**
         * Prints an error message to the console and exits the program.
         */
        private fun showErrorMessage() {
            println("Invalid arguments")
            println("Usage: java -jar starwars.jar <mapSize> <numberOfEnemies> <time>")
            println("Example: java -jar starwars.jar 5 15 3")
            exitProcess(-1)
        }
    }
}
