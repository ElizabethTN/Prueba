package com.example.prueba.data.response

import com.example.prueba.domain.models.Product

data class ProductosRespuesta(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)