package com.example.mywmtstore.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mywmtstore.data.model.Products
import com.example.mywmtstore.data.repository.ProductsRepository

class HomeViewModel : ViewModel() {
    private val productsRepository= ProductsRepository()
    private val products : MutableLiveData<List<Products>> = productsRepository.getProducts()

    fun getAllProducts():  MutableLiveData<List<Products>>{
        return products
    }

}