package com.example.prueba.domain.useCase

import com.example.prueba.data.ProductosApiService
import com.example.prueba.domain.listener.productoListener

class ProductoUseCase {

    //invocar
    suspend fun invokeListaProducto(listener: productoListener) {
        val api = ProductosApiService()
        api.getProductos(listener)
    }
}