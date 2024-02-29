package com.example.prueba.ui.theme.Pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.prueba.domain.ViewModel.HomeViewModel
import com.example.prueba.domain.models.Product
import com.example.prueba.ui.theme.blanco
import com.example.prueba.ui.theme.componentes.CardProductos
import com.example.prueba.ui.theme.componentes.Titulo

@Composable
fun Productos(
    //recibimos el navController
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    val productoLista: List<Product> by homeViewModel.ListaProducto.observeAsState(initial = emptyList())
    LaunchedEffect(true) {
        homeViewModel.getProductos()
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(blanco)
    ) {
        Column(
            Modifier
                .fillMaxSize()
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                Titulo()
            }
            Column(
                Modifier
                    .fillMaxWidth()
            ) {

                LazyColumn() {
                    items(productoLista) {
                        CardProductos(product = it, itemProducto = {
                            homeViewModel.openItemProducto(navController, it)
                        })
                    }
                }
            }
        }
    }
}