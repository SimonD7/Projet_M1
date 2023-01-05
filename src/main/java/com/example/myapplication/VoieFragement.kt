package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.VoieBinding
import com.example.myapplication.result.Result


class  VoieFragement:Fragment(){
    private lateinit var binding : VoieBinding
    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = VoieBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        binding.button3.setOnClickListener {
            val voie_name = Result(binding.text.text.toString(),null,null,null,null)
            val bundle = bundleOf("Result" to voie_name)
            findNavController().navigate(R.id.action_voie_to_numero,bundle )
        }

    }

}