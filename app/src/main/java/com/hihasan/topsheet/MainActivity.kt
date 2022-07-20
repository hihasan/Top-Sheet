package com.hihasan.topsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hihasan.topsheet.databinding.DemoLayoutBinding

class MainActivity : AppCompatActivity() {
    private var demoLayoutBinding : DemoLayoutBinding ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        demoLayoutBinding = DataBindingUtil.setContentView(this, R.layout.demo_layout)
        
        initViews()
    }

    private fun initViews() {
        TopSheetDialog(applicationContext, R.style.TopSheet_DialogAnimation).apply {
            // Required to have the top-down animation when the app starts showing / dismissin it.
            window?.attributes?.windowAnimations = R.style.TopSheet_DialogAnimation
            setContentView(demoLayoutBinding!!.root , ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }.show()
    }
}