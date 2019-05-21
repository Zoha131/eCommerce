package io.github.zoha131.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.github.zoha131.ecommerce.core.appComponent
import io.github.zoha131.ecommerce.databinding.ActivityMainBinding
import io.github.zoha131.ecommerce.di.ActivityComponent
import io.github.zoha131.ecommerce.shopping.productList.ProductListFragment

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = appComponent.getActivityComponent().create(this)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout,
            ProductListFragment()
        ).commit()

    }
}
