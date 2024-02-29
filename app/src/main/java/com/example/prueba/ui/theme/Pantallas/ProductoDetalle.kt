package com.example.prueba.ui.theme.Pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba.domain.ViewModel.HomeViewModel
import com.example.prueba.ui.theme.blanco
import com.example.prueba.ui.theme.componentes.Imagen
import com.example.prueba.ui.theme.componentes.btnRegresar
import com.example.prueba.ui.theme.componentes.descripcion
import com.example.prueba.ui.theme.componentes.precio
import com.example.prueba.ui.theme.componentes.tituloProducto
import com.example.prueba.ui.theme.componentes.tx_precio

@Composable
fun ProductosDetalle(
    //recibimos el navController
    navController: NavController,
    homeViewModel: HomeViewModel,
) {
    val itemProducto by homeViewModel.productoDetalle.observeAsState()

    Box(
        Modifier
            .fillMaxSize()
            .background(blanco)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Log.d("title", itemProducto?.title ?: "")
            tituloProducto(itemProducto?.title ?: "")

            //Imagen
            Log.d("imagen", itemProducto?.thumbnail ?: "")
            Imagen(itemProducto?.thumbnail ?: "")

            Column(
                Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //descripción
                Log.d("descripción", itemProducto?.description ?: "")
                descripcion(itemProducto?.description ?: "")

                Spacer(modifier = Modifier.padding(24.dp))
                //Precio
                Row {
                    tx_precio()
                    Log.d("precio", (itemProducto?.price ?: "").toString())
                    precio((itemProducto?.price ?: "").toString())

                }
            }

            Spacer(modifier = Modifier.padding(32.dp))
            //BtnRegresar
            btnRegresar(navController = navController)
        }
    }
}