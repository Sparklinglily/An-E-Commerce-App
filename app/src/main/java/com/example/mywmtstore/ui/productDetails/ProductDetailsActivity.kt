package com.example.mywmtstore.ui.productDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywmtstore.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}