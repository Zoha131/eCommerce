package io.github.zoha131.ecommerce.shopping.productList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import io.github.zoha131.ecommerce.R
import io.github.zoha131.ecommerce.core.BaseFragment
import io.github.zoha131.ecommerce.core.activityComponent
import io.github.zoha131.ecommerce.databinding.FragmentProductListBinding
import io.github.zoha131.ecommerce.di.FragmentComponent


class ProductListFragment : BaseFragment() {

    lateinit var fragmentBinding: FragmentProductListBinding
    lateinit var fragmentComponent: FragmentComponent
    val productListViewModel by lazy { fragmentComponent.getProductListViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentComponent = activityComponent.fragmentComponent().create(this)

        fragmentBinding = FragmentProductListBinding.inflate(layoutInflater, container, false)
        errorView = fragmentBinding.includeError.errorLayout
        loadingView = fragmentBinding.includeLoading.loadingLayout
        statusLiveData = productListViewModel.statusLiveData




        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productListViewModel.productListLiveData.observe(this, Observer { fragmentBinding.textview.text = it[0].title })
        fragmentBinding.includeError.warningBtn.setOnClickListener { productListViewModel.download() }
    }


}
