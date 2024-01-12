package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

//añade el contenido de los productos de los juguetes con su descripción y precio pasado por parámetro
//además de llamar a la función con el modelo de como se colocan los productos
@Composable
fun Juguetes(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
        "Piezas LEGO son bloques de construcción interconectables para crear diversas estructuras.",
        "Hot Wheels son autos de juguete en miniatura con diseños detallados y pistas de carreras.",
        "Un avión LEGO es un modelo de avión construido con piezas de LEGO, el popular juego de construcción.",
        "\"Figura Gundam\" se refiere a un juguete o figura de colección que representa uno de los robots de la serie Gundam, conocidos como Mobile Suits."
    )
    Column() {
        for (image in arrayOf(R.drawable.lego, R.drawable.hotwheels, R.drawable.avion, R.drawable.figura)) {
            model(image, values[index], descriptions[index++])
        }
    }
}