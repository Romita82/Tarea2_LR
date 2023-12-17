package com.example.tarea2

class CursosOnlineProvider {

    companion object {
        val cursosOnlineList = listOf<CursosOnline>(
            CursosOnline(
                "AristiDevs",
                "https://cursokotlin.com/",
                R.drawable.aristidevs,
                "Curso gratuito de Kotlin.",
                "https://bit.ly/3bmeQvm"
            ),
            CursosOnline(
                "Developers",
                "https://developer.android.com/kotlin",
                R.drawable.developers,
                "Android para desarrolladores",
                "GooglePlay"
            ),
            CursosOnline(
                "Mouredev",
                "https://mouredev.com/",
                R.drawable.mouredev,
                "Curso de Android desde cero.",
                "braismoure@mouredev.com"
            ),
            CursosOnline(
                "Jetbrains",
                "https://www.jetbrains.com/es-es/" +
                        "pages/academy/kotlin/",
                R.drawable.jetbrains,
                "Cree aplicaciones reales desde cero.",
                "https://twitter.com/JetBrains_Edu"

            ),
            CursosOnline(
                "Envatotuts+",
                "https://code.tutsplus.com/es",
                R.drawable.evantotuts,
                "Aprende habilidades creativas.",
                " https://evanto.com/contact"
            ),
            CursosOnline(
                "Udemy",
                "https://www.udemy.com/course/" +
                        "programacion-de-aplicaciones-android-kotlin",
                R.drawable.udemy,
                "La tienda virtual de aprendizaje y enseñanza global líder.",
                "Support@udemy.com"
            )

        )
    }
}