package com.example.prueba

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prueba.domain.ViewModel.HomeViewModel
import com.example.prueba.ui.theme.Pantallas.Productos
import com.example.prueba.ui.theme.Pantallas.ProductosDetalle

@Composable
fun ProductosNavegacion(
    homeViewModel: HomeViewModel
) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.PantallaProductos.route)
    {

        //Pantalla 1
        composable(route = Routes.PantallaProductos.route)
        {
            Productos(navController, homeViewModel)
        }

        //Pantalla 2
        composable(route = Routes.PantallaDetalleProductos.route)
        {
            ProductosDetalle(navController, homeViewModel)

        }
    }
}