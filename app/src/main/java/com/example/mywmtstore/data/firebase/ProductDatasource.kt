package com.example.mywmtstore.data.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mywmtstore.data.model.Products

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductDatasource {
    //get reference to the firestore database
    private val db = Firebase.firestore




    //create function that will fetch products from the database
    //a callback function
    fun getProductsInfo(): MutableLiveData<List<Products>>{
        val productLiveData = MutableLiveData<List<Products>>()
        db.collection("products")
            .get()
            .addOnSuccessListener { documents->
                val listOfProducts: List<Products> = documents.toObjects(Products::class.java)
                productLiveData.value = listOfProducts

        }
            .addOnFailureListener { error->
                Log.e("Firebase Error", error.message.toString())
            }
        return productLiveData

    }
}