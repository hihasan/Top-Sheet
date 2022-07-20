package com.hihasan.topsheet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import com.hihasan.topsheet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var view : View
    private lateinit var  topSheetDialog : TopSheetDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        topSheetDialog = TopSheetDialog(this@MainActivity)
        view = View.inflate(applicationContext, R.layout.demo_layout, null)

        binding.action.setOnClickListener {
            initViews()
        }


    }

    private fun initViews() {

        TopSheetDialog(this@MainActivity).apply {
            // Required to have the top-down animation when the app starts showing / dismissin it.
            window?.attributes?.windowAnimations = R.style.TopSheet_DialogAnimation
            setContentView(view ,
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT))

            actions()



        }.show()

        topSheetDialog = TopSheetDialog(this@MainActivity)
    }

    private fun actions() {
        val iv = view.findViewById<AppCompatImageView>(R.id.iv)
        iv.setOnClickListener {
            topSheetDialog.dismiss()
            val intent = Intent(this@MainActivity, TestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        topSheetDialog.dismissWithAnimation
    }

    override fun onStart() {
        super.onStart()
        topSheetDialog.dismissWithAnimation
    }

    override fun onResume() {
        super.onResume()
        topSheetDialog.dismissWithAnimation
    }
}