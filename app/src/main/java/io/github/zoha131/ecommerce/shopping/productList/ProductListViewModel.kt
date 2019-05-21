package io.github.zoha131.ecommerce.shopping.productList

import androidx.lifecycle.*
import io.github.zoha131.ecommerce.core.BaseViewModel
import io.github.zoha131.ecommerce.core.Failed
import io.github.zoha131.ecommerce.core.Loading
import io.github.zoha131.ecommerce.core.Success
import io.github.zoha131.ecommerce.model.Product
import io.github.zoha131.ecommerce.shopping.ShoppingRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductListViewModel(private val repository: ShoppingRepository) : BaseViewModel(){
    private var _productListLiveData = MutableLiveData<List<Product>>()
    val productListLiveData: LiveData<List<Product>> get() = Transformations.map(_productListLiveData) {it}

    fun getProductLiveData(id: Int):LiveData<Product> {
        val productLiveData = MutableLiveData<Product>()

        disposable.add(repository.getProduct(id)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { _statusLiveData.postValue(Loading) }
            .subscribe ({value -> productLiveData.postValue(value.body())
                _statusLiveData.postValue(Success)},
                {throwable -> _statusLiveData.postValue(Failed(throwable))}))

        return productLiveData
    }

    init {
        download()
    }

    fun download(){
        disposable.add(repository.getProductList()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { _statusLiveData.postValue(Loading) }
            .subscribe ({value -> _productListLiveData.postValue(value.body())
                        _statusLiveData.postValue(Success)},
                        {throwable -> _statusLiveData.postValue(Failed(throwable))}))
    }


}

class ProductListViewModelFactory @Inject constructor(private val repository: ShoppingRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(repository) as T
    }

}