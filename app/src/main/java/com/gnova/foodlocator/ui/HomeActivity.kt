package com.gnova.foodlocator.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnova.foodlocator.App
import com.gnova.foodlocator.R
import com.gnova.foodlocator.ViewModelFactory
import com.gnova.foodlocator.api.models.Restaurant
import kotlinx.android.synthetic.main.activity_home.*
import com.gnova.foodlocator.ui.MainViewState.Presenting
import com.gnova.foodlocator.ui.MainViewState.Error
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

        observeViewState()

    }

    private fun observeViewState() {
        viewModel.viewState.observe(this, Observer {
                when (it) {
                    is Presenting -> showRestaurants(it.Restaurants)
                    is Error -> Log.d("TAG", "ERROR")
                }
        })
    }

    private fun showRestaurants(restaurants: List<Restaurant>) {
        adapter.submitList(restaurants)

    }

    private fun setupRecyclerView() {
        restaurant_recycler_view.let {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.setHasFixedSize(true)
            it.adapter = adapter
        }
    }


}