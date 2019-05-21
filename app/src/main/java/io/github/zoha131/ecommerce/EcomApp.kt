package io.github.zoha131.ecommerce

import android.app.Activity
import android.app.Application
import io.github.zoha131.ecommerce.di.AppComponent
import io.github.zoha131.ecommerce.di.DaggerAppComponent

class EcomApp: Application(){
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create("https://my-json-server.typicode.com/zoha131/eCommerce/")
    }
}
