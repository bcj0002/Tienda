package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

//añade el contenido de los productos de la decoración con su descripción y precio pasado por parámetro
//además de llamar a la función con el modelo de como se colocan los productos
@Composable
fun Decoracion(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
        "Una estatua es una figura esculpida con fines decorativos o conmemorativos.",
        "Un cuadro es una obra de arte visual en lienzo, creado con pigmentos para expresar ideas, emociones o representar la realidad.",
        "Una fuente de jardín es una estructura decorativa que distribuye agua en un entorno de jardín con propósitos estéticos.",
        "Un candelabro es un soporte decorativo diseñado para sostener velas, generalmente con múltiples brazos o ramificaciones."
    )
    Column() {
        for (image in arrayOf(R.drawable.estatua, R.drawable.cuadro, R.drawable.fuente, R.drawable.candelabro)) {
            model(image, values[index], descriptions[index++])
        }
    }
}