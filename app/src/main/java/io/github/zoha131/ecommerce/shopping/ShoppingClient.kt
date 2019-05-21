package io.github.zoha131.ecommerce.shopping

import io.github.zoha131.ecommerce.model.Product
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShoppingClient{
    @GET("product/")
    fun getProductList(): Single<Response<List<Product>>>

    @GET("product/{id}")
    fun getProduct(@Path("id") id: Int): Single<Response<Product>>
}