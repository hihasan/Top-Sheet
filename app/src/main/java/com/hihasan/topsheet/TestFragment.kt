package com.hihasan.topsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hihasan.topsheet.databinding.DemoLayoutBinding

class TestFragment : Fragment() {
    private lateinit var binding : DemoLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DemoLayoutBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        binding.iv.setOnClickListener { Toast.makeText(requireContext(), "I AM Here No Need to fear", Toast.LENGTH_SHORT).show() }
    }
}