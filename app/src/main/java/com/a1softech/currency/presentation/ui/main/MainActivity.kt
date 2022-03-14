package com.a1softech.currency.presentation.ui.main

import android.os.Bundle
import com.a1softech.currency.R
import com.a1softech.currency.databinding.ActivityMainBinding
import com.a1softech.currency.presentation.base.view.BaseActivity

class MainActivity(override val layoutResourceId: Int = R.layout.activity_main) :
    BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(dataBinder: ActivityMainBinding) {

    }
}