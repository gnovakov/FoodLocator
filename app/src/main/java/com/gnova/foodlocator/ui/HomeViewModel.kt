package com.gnova.foodlocator.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gnova.data.repositories.JustEatRepoImpl
import com.gnova.foodlocator.ui.HomeViewState.Loading
import com.gnova.foodlocator.ui.HomeViewState.Presenting
import com.gnova.foodlocator.ui.HomeViewState.Error
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val justEatRepoImpl: JustEatRepoImpl): ViewModel()  {

    // View State
    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState>
        get() = _viewState

    fun onSearchBtnClick(outCode: String) {

        getRestaurants(outCode.filter{ it.isLetterOrDigit() || it.isWhitespace() })
    }



    /*private fun getRestaurants(outCode: String) {
        _viewState.value = Loading
        add(
            foodRepo.getRestaurants(outCode)
                .subscribe(
            {
                _viewState.value = Presenting(it.restaurants)
            }, {
                _viewState.value = Error
            }

        ))
    }*/

    private fun getRestaurants(outCode: String) {
        Log.i("TAG", "getRestaurants")
        Log.i("TAG", "getRestaurants " + outCode)
        _viewState.value = Loading
        add(
            justEatRepoImpl.getRestaurants(outCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.compose(schedulerProviderImpl.getSchedulers())
                .subscribe({
                    Log.i("TAG", " subscribe " + it) // doesnt fire?
                    _viewState.value = Presenting(it)
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