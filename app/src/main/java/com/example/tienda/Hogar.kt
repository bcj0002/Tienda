package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

//añade el contenido de los productos del hogar con su descripción y precio pasado por parámetro
//además de llamar a la función con el modelo de como se colocan los productos
@Composable
fun Hogar(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
        "Un sofá es un mueble para sentarse, generalmente con respaldo y brazos, diseñado para proporcionar comodidad en el área de descanso de un hogar.",
        "Un colchón es un soporte para dormir en una cama.",
        "Un armario es un mueble cerrado con puertas utilizado para almacenar ropa, objetos personales u otros artículos.",
        "Un edredón es una capa acolchada para la cama, proporcionando calor durante el sueño."
    )
    Column() {
        for (image in arrayOf(R.drawable.sofa, R.drawable.colchon, R.drawable.armario, R.drawable.edredon)) {
            model(image, values[index], descriptions[index++])
        }
    }
}