package com.example.mywmtstore.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mywmtstore.data.firebase.ProductDatasource
import com.example.mywmtstore.data.model.Products

class ProductsRepository {
    fun getProducts(): MutableLiveData<List<Products>>{
        val productDatasource = ProductDatasource()

        return productDatasource.getProductsInfo()

    }


}