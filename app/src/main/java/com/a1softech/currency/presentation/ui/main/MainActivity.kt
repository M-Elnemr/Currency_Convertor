package com.a1softech.currency.presentation.ui.main

import android.os.Bundle
import androidx.navigation.*
import com.a1softech.currency.R
import com.a1softech.currency.databinding.ActivityMainBinding
import com.a1softech.currency.presentation.base.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(override val layoutResourceId: Int = R.layout.activity_main) :
    BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(dataBinder: ActivityMainBinding) {
        navController = findNavController(R.id.nav_host)
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }

    fun navigate(action: NavDirections, extra: Navigator.Extras? = null, popup: Boolean = false) {
        if (extra == null)
            navController.navigate(action)
        else
            navController.navigate(action, extra)
    }

    fun navigate(id: Int, args: Bundle? = null, extra: Navigator.Extras? = null) {
        navController.navigate(id, args, null, extra)
    }

    fun navigate(deepLink: NavDeepLinkRequest) {
        navController.navigate(deepLink)
    }


}