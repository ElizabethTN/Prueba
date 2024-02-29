package com.example.prueba.ui.theme.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba.Routes
import com.example.prueba.domain.models.Product
import com.example.prueba.domain.models.ProductDetalle
import com.example.prueba.ui.theme.azul
import com.example.prueba.ui.theme.blanco

@Composable
fun CardProductos(
    product: Product,
    itemProducto: (Product) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 13.dp)
            .background(blanco)
            .clickable {
                // Llamada a la función itemProducto con el producto seleccionado
                itemProducto(product)
            },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = azul)
    ) {
        val title = rememberSaveable { mutableStateOf(product.title) }
        val thumbnail = rememberSaveable { mutableStateOf(product.thumbnail) }
        val description = rememberSaveable { mutableStateOf(product.description) }
        val price = rememberSaveable { mutableStateOf(product.price) }

        val product: ProductDetalle = ProductDetalle(
            title = title.value,
            thumbnail = thumbnail.value,
            description = description.value,
            price = price.value
        )

        Column(
            Modifier.background(blanco),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                )
                {
                    tx_nombreProducto()
                    nombreProducto(product.title)
                }
                Column(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                )
                {
                    descripcion(product.description)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                )
                {
                    tx_precio()
                    precio(product.price)
                }
            }
        }
    }
}