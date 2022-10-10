package com.example.mywmtstore.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mywmtstore.data.model.Products
import com.example.mywmtstore.data.repository.CartRepository

class CartViewModel : ViewModel() {


    fun getProducts(): List<Products> {
        return CartRepository.getSelectedProducts().keys.toList()

    }

    fun increaseQuantity(){

    }
    fun decreaseQuantity(){

    }
}