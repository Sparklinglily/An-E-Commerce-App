package com.example.mywmtstore.ui.productDetails

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.example.mywmtstore.R
import com.example.mywmtstore.data.model.Products
import com.example.mywmtstore.databinding.FragmentProductDetailsListDialogBinding



class ProductDetailsFragment (val products: Products): BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductDetailsListDialogBinding
    private lateinit var productDetailsViewModel: ProductDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //what does this line of code do
        productDetailsViewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)

        binding = FragmentProductDetailsListDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //load image
        Glide.with(requireActivity())
            .load(products.image)
            .into(binding.productImage)

        //show details

        binding.productName.text = products.name
        binding.price.text = "${products.price}"
        binding.seller.text= products.seller

        //when the add to cart is clicked
        binding.addToCart.setOnClickListener {
          //alert user that it has been added to cart
            productDetailsViewModel. saveToCart(products)
            //alert user it has been added to cart
            Toast.makeText(requireContext(),"Saved To Cart",Toast.LENGTH_LONG).show()
            binding.addToCart.text = "Remove from Cart"
        }


    }
}