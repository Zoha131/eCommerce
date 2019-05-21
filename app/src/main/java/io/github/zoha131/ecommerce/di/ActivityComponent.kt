package io.github.zoha131.ecommerce.di

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.github.zoha131.ecommerce.shopping.ShoppingClient
import io.github.zoha131.ecommerce.shopping.ShoppingRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):ActivityComponent
    }

    fun provideShoppingRepository(): ShoppingRepository
    fun fragmentComponent(): FragmentComponent.Factory

}

@Module
object ActivityModule{


    @Provides
    @ActivityScope
    @JvmStatic
    fun provideShoppingClient(retrofit: Retrofit): ShoppingClient {
        return retrofit.create(ShoppingClient::class.java)
    }
}
