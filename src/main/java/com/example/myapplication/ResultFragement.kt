package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.ResultBinding
import com.example.myapplication.databinding.StartBinding
import com.example.myapplication.databinding.VoieBinding


import dagger.hilt.android.AndroidEntryPoint


class  ResultFragement:Fragment(){
    private lateinit var binding :ResultBinding
    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = ResultBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_fin_to_voie)
        }
    }

}