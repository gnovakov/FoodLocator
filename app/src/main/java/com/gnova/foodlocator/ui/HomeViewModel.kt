package com.gnova.foodlocator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gnova.foodlocator.api.FoodRepo
import com.gnova.foodlocator.ui.HomeViewState.Loading
import com.gnova.foodlocator.ui.HomeViewState.Presenting
import com.gnova.foodlocator.ui.HomeViewState.Error
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val foodRepo: FoodRepo): ViewModel()  {

    // View State Version
    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState>
        get() = _viewState

    fun onSearchBtnClick(outCode: String) {

        getRestaurants(outCode.filter{ it.isLetterOrDigit() || it.isWhitespace() })
    }



    private fun getRestaurants(outCode: String) {
        _viewState.value = Loading
        add(
            foodRepo.getRestaurants(outCode)
                .subscribe(
            {
                _viewState.value = Presenting(it.Restaurants)
            }, {
                _viewState.value = Error
            }

        ))
    }

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}