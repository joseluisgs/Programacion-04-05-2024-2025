package models

private const val SIZE = 5
private const val MAX_VALUE = 20
private const val PROB_MINERAL = 50
private const val MAX_TIME = 30
private const val PROB_TAKE_MINERAL = 50
private const val PAUSE_TIME = 1000L // (1 segundo)
private const val NUM_MINERALS_TAKEN = 2
private const val PROB_DECISION = 30

data class Configuracion(
    val size: Int = SIZE,
    val maxValue: Int = MAX_VALUE,
    val probMineral: Int = PROB_MINERAL,
    val maxTime: Int = MAX_TIME,
    val probTakeMineral: Int = PROB_TAKE_MINERAL,
    val pauseTime: Long = PAUSE_TIME,
    val numMineralsTaken: Int = NUM_MINERALS_TAKEN,
    val probDecision: Int = PROB_DECISION
)