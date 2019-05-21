package io.github.zoha131.ecommerce.core

import android.app.Activity
import androidx.fragment.app.Fragment
import io.github.zoha131.ecommerce.EcomApp
import io.github.zoha131.ecommerce.MainActivity

val Activity.appComponent get() = (application as EcomApp).appComponent
val Fragment.activityComponent get() = (activity as MainActivity).activityComponent