package models

/**
 * Clase que representa la configuración del cine
 *
 * @property filas Número de filas de la sala, por defecto 3
 * @property columnas Número de columnas de la sala, por defecto 3
 */
data class Configuracion(val filas: Int = 3, val columnas: Int = 3)
