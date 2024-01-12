package com.example.tienda

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

//añade el contenido de los productos de la cocina con su descripción y precio pasado por parámetro
//además de llamar a la función con el modelo de como se colocan los productos
@Composable
fun Cocina(values: Array<Float>) {
    var index = 0
    var descriptions = arrayOf(
            "Un sartén es un utensilio de cocina circular con bordes elevados y mango, utilizado para freír, saltear y cocinar alimentos.",
            "Una espátula es una herramienta plana con mango, comúnmente de metal o silicona, utilizada para voltear, mezclar o raspar alimentos en utensilios de cocina.",
            "Una cacerola es un recipiente redondo y poco profundo con asas, utilizado para cocinar diversos alimentos como guisos, sopas y salsas.",
            "Un cucharón es una herramienta de cocina con una gran cuchara en un extremo, utilizada para servir sopas y guisos."
        )
    Column() {
        for (image in arrayOf(R.drawable.sarten, R.drawable.espatula, R.drawable.cacerola, R.drawable.cucharon)) {
            model(image, values[index], descriptions[index++])
        }
    }
}