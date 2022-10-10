package com.example.mywmtstore.data.repository

import com.example.mywmtstore.data.model.Products

object CartRepository {
   private val selectedProducts = mutableMapOf<Products, Int>()

    fun addToCart(products: Products){
        selectedProducts.put(products, 1)

        }
    fun removeFromCart(products: Products){
        selectedProducts.remove(products)
    }


    fun decreaseQuantity(products: Products){
        //get quantity
        var quantity: Int= selectedProducts[products]!!
        quantity--
        selectedProducts[products]= quantity

    }

    fun increaseQuantity(products: Products){
        var quantity: Int= selectedProducts[products]!!
        quantity++
        selectedProducts[products]= quantity

    }

    fun getPrice(): Double {
        var price: Double = 0.0
        for (items in selectedProducts.keys) {
            price += items.price!!
        }
        return  price
    }
    //quantity
    fun getSelectedProducts(): Map<Products, Int>{
        return  selectedProducts.toMap()
    }
}