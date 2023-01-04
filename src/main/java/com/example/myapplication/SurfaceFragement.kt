package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.StartBinding
import com.example.myapplication.databinding.SurfarceBinding
import com.example.myapplication.databinding.VoieBinding


import dagger.hilt.android.AndroidEntryPoint


class  SurfaceFragement:Fragment(){
    private lateinit var binding : SurfarceBinding
    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = SurfarceBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_surface_to_piece )
        }
    }

}