package io.github.zoha131.ecommerce.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import io.github.zoha131.ecommerce.MainActivity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent{


    @Component.Factory
    interface Factory{
        fun create(@BindsInstance @Named("url")baseURL: String): AppComponent
    }

    fun getActivityComponent():ActivityComponent.Factory

}

@Module
object AppModule{

    @AppScope
    @Provides
    @JvmStatic
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient()
    }



    @AppScope
    @Provides
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("url")baseURL: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}