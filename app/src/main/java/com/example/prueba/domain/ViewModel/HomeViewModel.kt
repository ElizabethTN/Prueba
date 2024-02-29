package com.example.prueba.domain.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.prueba.Routes
import com.example.prueba.domain.listener.productoListener
import com.example.prueba.domain.models.Product
import com.example.prueba.domain.useCase.ProductoUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _ListaProducto = MutableLiveData<List<Product>>()
    val ListaProducto: LiveData<List<Product>> get() = _ListaProducto

    private val _productoDetalle = MutableLiveData<Product>()
    val productoDetalle: LiveData<Product> get() = _productoDetalle

    suspend fun getProductos() {
        val usecase = ProductoUseCase()
        _loading.value = true
        viewModelScope.launch {
            usecase.invokeListaProducto(object : productoListener {
                override fun onSuccess(productoLista: List<Product>) {

                    _ListaProducto.value = productoLista
                    _loading.value = false
                }

                override fun onError(error: String) {
                    Log.e("Error", error)
                }

            })

        }
    }

    fun openItemProducto(navController: NavController, item: Product) {
        _productoDetalle.value = item
        navController.navigate(Routes.PantallaDetalleProductos.route)
    }
}
