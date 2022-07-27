package com.example.mystore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mystore.models.Product
import com.example.mystore.repository.ProductRespository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRespository) : ViewModel(){

    val productsLiveData : LiveData<List<Product>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}