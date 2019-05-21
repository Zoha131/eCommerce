package io.github.zoha131.ecommerce.core

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

open class BaseFragment: Fragment(){
    lateinit var statusLiveData: LiveData<Async>
    lateinit var errorView: View
    lateinit var loadingView: View

    override fun onResume() {
        super.onResume()

        statusLiveData.observe(this, Observer { syncWithStatus(it) })
    }


    private fun syncWithStatus(status: Async){
        when(status){
            is Loading -> {
                errorView.visibility = View.GONE
                loadingView.visibility = View.VISIBLE
            }
            is Failed -> {
                errorView.visibility = View.VISIBLE
                loadingView.visibility = View.GONE
            }
            is Success -> {
                errorView.visibility = View.GONE
                loadingView.visibility = View.GONE
            }
        }
    }


}