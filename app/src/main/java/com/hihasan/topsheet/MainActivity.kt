package com.hihasan.topsheet


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
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

        binding.profileIv.setOnClickListener {
            initViews()
        }


    }

    private fun initViews() {

        var topSheetDialog = TopSheetDialog(this@MainActivity).apply {
            // Required to have the top-down animation when the app starts showing / dismissin it.
            window?.attributes?.windowAnimations = R.style.TopSheet_DialogAnimation
            setContentView(view ,
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT))

            actions()



        }.show()
    }

    private fun actions() {
        val iv = view.findViewById<TextView>(R.id.save_btn)
        iv.setOnClickListener {
            topSheetDialog.dismiss()
            Toast.makeText(applicationContext, "Action Pressed", Toast.LENGTH_SHORT).show()
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