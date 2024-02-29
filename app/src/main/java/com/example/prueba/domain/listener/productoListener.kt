package com.example.prueba.domain.listener

import com.example.prueba.domain.models.Product

interface productoListener {
    //el chismoso

    //Petición exitosa
    fun onSuccess(productoLista: List<Product>)

    //Petición fallida
    fun onError(error: String)
}