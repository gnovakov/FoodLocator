package com.gnova.foodlocator.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gnova.foodlocator.App
import com.gnova.foodlocator.FoodApiStatus
import com.gnova.foodlocator.R
import com.gnova.foodlocator.ViewModelFactory
import com.gnova.foodlocator.api.models.Restaurant
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<HomeViewModel>
    private lateinit var viewModel: HomeViewModel

    private val adapter: RestaurantAdapter by lazy {
        RestaurantAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        search_button.setOnClickListener {
            viewModel.onSearchBtnClick(search_input.text.toString());
        }

        setupRecyclerView()

        observeApiStatus()

    }

    private fun observeApiStatus() {
        viewModel.apiStatus.observe(this, Observer {
            it?.let {
                when (it) {
                    FoodApiStatus.LOADING -> {
                        Log.d("TAG", "LOADING")
                    }
                    FoodApiStatus.ERROR -> {
                        Log.d("TAG", "ERROR")
                    }
                    FoodApiStatus.DONE -> {
                        Log.d("TAG", "DONE")
                        observeRestaurants()
                    }

                }
            }
        })
    }

    private fun observeRestaurants() {
        viewModel.restaurants.observe(this, Observer {
            it?.let {
                showRestaurants(it)
            }
        })
    }

    private fun showRestaurants(restaurants: List<Restaurant>) {
        //Log.d("TAG", "Restaurants " + restaurants[0].Id)
        adapter.submitList(restaurants)

    }

    private fun setupRecyclerView() {
        restaurant_recycler_view.setHasFixedSize(true)
        restaurant_recycler_view.layoutManager = GridLayoutManager(this, 1)
        restaurant_recycler_view.adapter = adapter
    }
}