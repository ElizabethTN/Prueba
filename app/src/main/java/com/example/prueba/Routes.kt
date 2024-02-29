package com.example.prueba

sealed class Routes(val route: String) {

    object PantallaProductos : Routes("Pantalla_Productos")
    object PantallaDetalleProductos : Routes("Pantalla_Detalle_Productos")
}

