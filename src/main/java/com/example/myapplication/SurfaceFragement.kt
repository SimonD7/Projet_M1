package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController

import com.example.myapplication.databinding.SurfarceBinding
import com.example.myapplication.result.Result


class  SurfaceFragement:Fragment(){
    private lateinit var binding : SurfarceBinding
    private lateinit var Res : Result
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            Res  = bundle.getParcelable("Result")!!
        }
    }
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
            if(binding.text.text.toString().isEmpty() || binding.text2.text.toString().isEmpty() ) {
                Toast.makeText(context,"il faut remplir tous les champs", Toast.LENGTH_LONG).show()

            } else {
                Res.surfaceb = binding.text.text.toString().toInt()
                Res.surfacet = binding.text2.text.toString().toInt()
                val bundle = bundleOf("Result" to Res)
                findNavController().navigate(R.id.action_surface_to_piece, bundle)
            }
        }
        binding.button2.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}