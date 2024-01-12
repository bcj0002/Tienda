package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun Electronica(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
        "Un altavoz es un dispositivo de salida de audio que amplifica y reproduce sonidos.",
        "Un equipo DJ es un conjunto de dispositivos y herramientas utilizadas por un disc jockey para mezclar y reproducir música en eventos o actuaciones.",
        "Un cable de extensión es un alargador eléctrico que permite extender la distancia entre un dispositivo eléctrico y una toma de corriente.",
        "Una televisión es un dispositivo para ver imágenes en movimiento y escuchar sonido."
    )
    Column() {
        for (image in arrayOf(R.drawable.altavoz, R.drawable.dj, R.drawable.extension, R.drawable.television)) {
            model(image, values[index], descriptions[index++])
        }
    }
}