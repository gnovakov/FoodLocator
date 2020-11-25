package com.gnova.foodlocator.ui

import android.util.Log
import androidx.lifecycle.*
import com.gnova.foodlocator.FoodApiStatus
import com.gnova.foodlocator.api.FoodRepo
import com.gnova.foodlocator.api.models.Restaurant
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val foodRepo: FoodRepo): ViewModel()  {

    // The most recent API response
    private val _apiStatus = MutableLiveData<FoodApiStatus>()
    val apiStatus: LiveData<FoodApiStatus>
        get() = _apiStatus

    // A Restaurant
    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>>
        get() = _restaurants

    fun onSearchBtnClick(outCode: String) {

        getRestaurants(outCode.filter{ it.isLetterOrDigit() || it.isWhitespace() })
    }



    private fun getRestaurants(outCode: String) {
        add(foodRepo.getRestaurants(outCode).subscribe(
            {
                //_apiStatus.value = FoodApiStatus.LOADING
                _apiStatus.postValue(FoodApiStatus.LOADING)
                //_restaurants.value = it.Restaurants
                _restaurants.postValue(it.Restaurants)
                //_apiStatus.value = FoodApiStatus.DONE
                _apiStatus.postValue(FoodApiStatus.DONE)
            }, {
                //_apiStatus.value = FoodApiStatus.ERROR
                _apiStatus.postValue(FoodApiStatus.ERROR)
                //_restaurants.value = ArrayList()
                _restaurants.postValue(ArrayList())
            }

        ))
    }

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanUp() {
        compositeDisposable.clear()
    }

}