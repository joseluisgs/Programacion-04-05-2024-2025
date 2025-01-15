package models

private const val SPACE_SIZE = 5
private const val NUM_ALIENS = 10
private const val ALIENS_MAX_LIVES = 1
private const val MAX_TIME = 30
private const val PAUSE_TIME = 1000L // (1 segundo)
private const val MAX_LIVES = 5
private const val TIME_ATACK = 5
private const val PROB_ATACK = 40
private const val PROB_ACCURACY = 70
private const val MAX_TRIES_TO_MOVE = 16

/**
 * Class that represents the configuration of the simulation.
 * @property spaceSize Size of the space.
 * @property numAliens Number of aliens.
 * @property aliensMaxLives Maximum number of lives of the aliens.
 * @property maxTime Maximum time of the simulation.
 * @property pauseTime Pause time between turns.
 * @property maxLives Maximum number of lives of the player.
 * @property timeAtack Time between alien attacks.
 * @property probAtack Probability of alien attack.
 * @property probAccuracy Probability of alien accuracy.
 * @property maxTriesToMove Maximum number of tries to move an alien.
 * @constructor Creates a configuration with the default values.
 * @see Space
 */
data class Configuration(
    val spaceSize: Int = SPACE_SIZE,
    val numAliens: Int = NUM_ALIENS,
    val aliensMaxLives: Int = ALIENS_MAX_LIVES,
    val maxTime: Int = MAX_TIME,
    val pauseTime: Long = PAUSE_TIME,
    val maxLives: Int = MAX_LIVES,
    val timeAtack: Int = TIME_ATACK,
    val probAtack: Int = PROB_ATACK,
    val probAccuracy: Int = PROB_ACCURACY,
    val maxTriesToMove: Int = MAX_TRIES_TO_MOVE
)