package com.gnova.foodlocator.di.modules

import com.gnova.foodlocator.api.FoodApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    @Reusable
    fun providesRetrofit(
        okHttpClient: OkHttpClient.Builder): FoodApi =
        Retrofit.Builder()
            .baseUrl("https://uk.api.just-eat.io/")
            .client(
                okHttpClient
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Needed for Rx
            .build()
            .create(FoodApi::class.java)

    @Provides
    @Reusable
    fun providesOkHttpClient(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

}