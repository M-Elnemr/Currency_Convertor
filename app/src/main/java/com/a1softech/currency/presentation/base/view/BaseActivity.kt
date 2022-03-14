package com.a1softech.currency.presentation.base.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<in T> :
    AppCompatActivity() where T : ViewDataBinding {

    abstract fun onActivityCreated(dataBinder: T)

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this@BaseActivity.initial()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
    }

    private fun initial() {
        this@BaseActivity.layoutResourceId.let {
            val dataBinder = DataBindingUtil.setContentView<T>(this@BaseActivity, it)
            this@BaseActivity.onActivityCreated(dataBinder)
        }
    }

    override fun onBackPressed() {
        try {
            super.onBackPressed()
        } catch (e: Exception) {
            Toast.makeText(this, "Crash", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}