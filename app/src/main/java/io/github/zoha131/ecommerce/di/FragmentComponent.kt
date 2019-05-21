package io.github.zoha131.ecommerce.di

import androidx.lifecycle.ViewModelProviders
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.github.zoha131.ecommerce.core.BaseFragment
import io.github.zoha131.ecommerce.shopping.productList.ProductListViewModel
import io.github.zoha131.ecommerce.shopping.productList.ProductListViewModelFactory

@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create(@BindsInstance fragment: BaseFragment):FragmentComponent
    }

    fun getProductListViewModel(): ProductListViewModel

}


@Module
object FragmentModule{

    @FragmentScope
    @Provides
    @JvmStatic
    fun provideListViewModel(fragment: BaseFragment, factory: ProductListViewModelFactory): ProductListViewModel {
        return ViewModelProviders.of(fragment, factory).get(ProductListViewModel::class.java)
    }
}
