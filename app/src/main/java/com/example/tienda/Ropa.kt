package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

//añade el contenido de los productos de la ropa con su descripción y precio pasado por parámetro
//además de llamar a la función con el modelo de como se colocan los productos
@Composable
fun Ropa(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
        "Una sudadera es una prenda informal con mangas largas y capucha, ideal para mantener el torso abrigado.",
        "Zapatos de vestir son calzado elegante diseñado para ocasiones formales o profesionales, destacando por su estilo refinado.",
        "Las sandalias son un tipo de calzado que deja los dedos, talón y parte del pie al descubierto, sujetándose mediante correas u otros diseños.",
        "Una bufanda es una prenda larga y estrecha, generalmente de tela suave, diseñada para envolverse alrededor del cuello para proporcionar calor y estilo."
    )
    Column() {
        for (image in arrayOf(R.drawable.guchi, R.drawable.elegancia, R.drawable.sandalias, R.drawable.bufanda)) {
            model(image, values[index], descriptions[index++])
        }
    }
}