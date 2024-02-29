package com.example.prueba.data

import android.util.Log
import com.example.prueba.data.Paths.BASE_URL
import com.example.prueba.data.response.ProductosRespuesta
import com.example.prueba.domain.listener.productoListener
import com.example.prueba.domain.models.Product
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductosApiService {

    suspend fun getProductos(listener: productoListener) {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(productosCliente::class.java)

        val productoResponse: Response<ProductosRespuesta> = service.getProductos()
        if (productoResponse.isSuccessful) {
            val productoObj: ProductosRespuesta? = productoResponse.body()
            val productoLista: List<Product>? = productoObj?.products

            if (productoLista != null) {
                listener.onSuccess(productoLista)
            } else {
                listener.onError("Lista de productos nula")
            }
        } else {
            listener.onError("Error en la respuesta del servidor: ${productoResponse.code()}")
        }
    }
}