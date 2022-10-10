package com.example.mywmtstore.ui.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mywmtstore.R
import com.example.mywmtstore.data.model.Products
import com.google.android.material.button.MaterialButton

class CartAdapter(val context: Context, val listOfSelectedProducts: List<Products>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_cart, parent, false)

        return CartViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val products: Products = listOfSelectedProducts[position]
        holder.productName.text= products.name
        holder.price.text= "${products.price}"
        Glide.with(context)
            .load(products.image)
            .into(holder.image)



    }

    override fun getItemCount(): Int {
        return listOfSelectedProducts.size
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView= itemView.findViewById(R.id.image)
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val price: TextView= itemView.findViewById(R.id.price)
        val quantity: TextView= itemView.findViewById(R.id.quantity)
        val increaseQty: MaterialButton= itemView.findViewById(R.id.increase_quantity)
        val deleteBtn: MaterialButton = itemView.findViewById(R.id.delete)

    }

}
