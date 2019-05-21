package io.github.zoha131.ecommerce.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import io.github.zoha131.ecommerce.core.Async
import io.github.zoha131.ecommerce.core.Failed
import io.github.zoha131.ecommerce.core.Loading
import io.github.zoha131.ecommerce.core.Success
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class ShoppingRepository @Inject constructor(private val shoppingClient: ShoppingClient) {

    fun getProductList() = shoppingClient.getProductList()

    fun getProduct(id: Int) = shoppingClient.getProduct(id)
}