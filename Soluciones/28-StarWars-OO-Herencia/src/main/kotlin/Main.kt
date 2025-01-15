import controllers.StrikeShip
import models.Configuation

/**
 * The main method for running the "Star Wars: The Clone Wars" game simulation.
 * It initializes the game configuration, creates a StrikeShip with the given configuration,
 * simulates the game, and prints the final report.
 *
 * @param args An array of command-line arguments passed to the program.
 */
fun main(args: Array<String>) {
    println("Star Wars: The Clone Wars")
    println("May the force be with you")
    println()
    val config = Configuation.fromArgs(args)
    val strike = StrikeShip(config.mapSize, config.numberOfEnemies, config.time)
    strike.simulate()
    println()
    strike.printReport()
}