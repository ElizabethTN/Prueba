package com.example.prueba.data

import com.example.prueba.data.Paths.productos
import com.example.prueba.data.response.ProductosRespuesta
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface productosCliente {

    @GET(productos)
    suspend fun getProductos(): Response<ProductosRespuesta>
}