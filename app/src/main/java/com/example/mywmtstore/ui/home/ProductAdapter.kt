package com.example.mywmtstore.ui.home


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mywmtstore.R
import com.example.mywmtstore.data.model.Products
import com.example.mywmtstore.ui.productDetails.ProductDetailsActivity
import com.example.mywmtstore.ui.productDetails.ProductDetailsFragment

class ProductAdapter(val context: Context,
                     val listOfProducts: List<Products>,
                     val fragmentManager: FragmentManager
             ): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.layout_for_products, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //
        val products = listOfProducts[position]
        //show product name
        holder.productName.text = products.name
        //show product price
        holder.price.text = "$${products.price}"
        //show image
        val imageUrl = products.image
        Glide.with(context)
            .load(imageUrl)
            .into(holder.productImage)

        //set onclicklistener to the item so that when an item is clicked it takes us to the modal bottom sheeet and display the product details for each item
        holder.itemView.setOnClickListener {
            ProductDetailsFragment(products).show(fragmentManager, "howdy")


        }
    }

    override fun getItemCount(): Int = listOfProducts.size


}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productName: TextView= itemView.findViewById(R.id.product_name)
    val productImage: ImageView= itemView.findViewById(R.id.product_image)
    val price: TextView= itemView.findViewById(R.id.price)

}
