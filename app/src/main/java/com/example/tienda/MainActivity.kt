package com.example.tienda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUp()
        }
    }
}

//Crea el menu desplegable y llama a la función que crean el contenido
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SetUp() {
    var shop by remember {
        mutableStateOf("Cocina")
    }
    val menuState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val accionMovimiento = rememberCoroutineScope()
    var index by remember() {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    val tabs = arrayOf("Cocina", "Decoración", "Electrónica", "Hogar", "Juguetes", "Ropa")
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    ModalNavigationDrawer(
        drawerState = menuState,
        drawerContent = {
            ModalDrawerSheet {
                ListItem(
                    headlineText = {
                        Text(
                            "TIENDAS",
                            fontSize = 30.sp,
                            color = Color(217, 217, 217)
                        )
                    },
                    leadingContent = {
                        IconButton(
                            onClick = {
                                accionMovimiento.launch { menuState.close() }
                            },
                            modifier = Modifier
                                .size(35.dp)
                                .padding(top = 3.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Close",
                                modifier = Modifier.fillMaxSize(),
                                tint = Color(217, 217, 217)
                            )
                        }
                    },
                    colors = ListItemDefaults.colors(containerColor = Color.Black),
                    modifier = Modifier.height(80.dp)
                )
                Divider()
                for (i in tabs) {
                    NavigationDrawerItem(
                        label = { Text(text = i, fontSize = 18.sp) },
                        selected = (index == tabs.indexOf(i)),
                        onClick = {
                            accionMovimiento.launch { menuState.close() }
                            index = tabs.indexOf(i)
                            navController.navigate(i)
                            shop = i
                        }
                    )
                }
            }
        },
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    modifier = Modifier.background(Color.Black),
                    title = {
                        Text(
                            text = "Armamento Nuclear Market",
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 25.sp,
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                accionMovimiento.launch { menuState.open() }
                            }, modifier = Modifier
                                .background(Color.Black)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menú",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.White,
                    )
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(75.dp)
                                    .height(30.dp)
                                    .border(2.dp, Color.Black)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Imagen"
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(70.dp)
                                    .height(30.dp)
                                    .border(2.dp, Color.Black)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Precio"
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                                    .width(230.dp)
                                    .height(30.dp)
                                    .border(2.dp, Color.Black)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Descripción"
                                )
                            }
                        }
                        content(tabs, navController)
                    }
                }
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    modifier = Modifier.height(50.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = shop,
                        fontSize = TextUnit(20f, TextUnitType.Sp),
                        fontFamily = FontFamily.Monospace,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        )
    }
}

//pone los valores de las pestaañas del navegador y pasa los valores de los productos
@Composable
fun content(tabs: Array<String>, navController: NavHostController) {
    var values = Array(24) { 0f }
    for (i in 0 until values.size) {
        values[i] = ((Math.random() * 10 + 10) * 100).toInt().toFloat() / 100
    }
    NavHost(navController = navController, startDestination = tabs[0]) {
        composable(tabs[0]) {
            Cocina(values.sliceArray(0..3))
        }
        composable(tabs[1]) {
            Decoracion(values.sliceArray(4..7))
        }
        composable(tabs[2]) {
            Electronica(values.sliceArray(8..11))
        }
        composable(tabs[3]) {
            Hogar(values.sliceArray(12..15))
        }
        composable(tabs[4]) {
            Juguetes(values.sliceArray(16..19))
        }
        composable(tabs[5]) {
            Ropa(values.sliceArray(20..23))
        }
    }
}

//función que tiene el modelo de los contenidos de cada tienda
@Composable
fun model(image: Int, value: Float, description: String) {
    Row(modifier = Modifier.height(84.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.width(75.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "$value$",
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .width(70.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "$description",
            color = Color.White,
            modifier = Modifier
                .width(230.dp),
            textAlign = TextAlign.Left
        )
    }
}