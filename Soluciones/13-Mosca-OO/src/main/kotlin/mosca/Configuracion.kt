package mosca

/**
 * Configuración del juego de la mosca
 * @param tam Tamaño del tablero
 * @param numIntentos Número de intentos
 */

const val TAM_DEFAULT = 8
const val NUM_INTENTOS_DEFAULT = 5

data class Configuracion(val tam: Int = TAM_DEFAULT, val numIntentos: Int = NUM_INTENTOS_DEFAULT, val numVidas: Int = 3)
