package com.example.mywmtstore.ui.home

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mywmtstore.R
import com.example.mywmtstore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost= requireActivity()
        menuHost.addMenuProvider(HomeMenuProvider(), viewLifecycleOwner, Lifecycle.State.RESUMED)
        //LISTEN FOR PRODUCTS

        homeViewModel.getAllProducts().observe(viewLifecycleOwner){listOfFetchedProducts ->
            //binding the list of products to the home Fragment layout
            //SPANCOUNT IS ABOUT THE NUMBER OF COLUMNS THE PRODUCT SHOULD BE IN, BEFORE IT BREAKS AND
            //GOES TO THE NEXT LINE
           binding.listOfProducts.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.listOfProducts.adapter = ProductAdapter(requireContext(),listOfFetchedProducts, childFragmentManager)

        }
    }

}
class HomeMenuProvider(): MenuProvider {
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.home_menu,menu)
    }

    override fun onMenuItemSelected (menuItem: MenuItem): Boolean {
       return true
    }
}