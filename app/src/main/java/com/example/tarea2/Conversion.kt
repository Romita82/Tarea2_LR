package com.example.tarea2


    object Conversion {
        @Throws(NumberFormatException::class)
        fun convertirADolares(cantidad: String, cambio: Double): String {
            val valor = cantidad.toDouble() / cambio
            return String.format("%.2f", valor)

        }
        @Throws(NumberFormatException::class)
        fun convertirAEuros(cantidad: String, cambio: Double): String {
            val valor = cantidad.toDouble() * cambio
            return String.format("%.2f", valor)
        }
    }



