package com.example.mywmtstore.ui.productDetails

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.mywmtstore.data.model.Products
import com.example.mywmtstore.data.repository.CartRepository

class ProductDetailsViewModel(): ViewModel() {

    //whats the products for
    fun saveToCart (products: Products){

        CartRepository.addToCart(products)


    }
}