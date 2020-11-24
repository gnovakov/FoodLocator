package com.gnova.foodlocator.di

import android.content.Context
import com.gnova.foodlocator.di.modules.ApiModule
import com.gnova.foodlocator.di.modules.AppModule
import com.gnova.foodlocator.ui.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

        fun inject(activity: HomeActivity)

}