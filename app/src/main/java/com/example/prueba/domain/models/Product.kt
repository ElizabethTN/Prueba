package com.example.prueba.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: String,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
) : Parcelable

@Parcelize
data class ProductDetalle(
    val description: String,
    val price: String,
    val thumbnail: String,
    val title: String
) : Parcelable