package io.github.zoha131.ecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(val id: Int,
                   val category:String,
                   val title: String,
                   val description:String,
                   val price: Double,
                   val rating: Double,
                   val image: String,
                   val specs: List<Spec>): Parcelable

@Parcelize
data class Spec(val title:String, val value:String):Parcelable
