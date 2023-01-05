package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.NumeroBinding
import com.example.myapplication.result.Result


class  numeroFragement:Fragment(){
    private lateinit var binding : NumeroBinding
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
        binding = NumeroBinding.inflate( inflater )
        return binding.root
    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        val args : numeroFragementArgs by navArgs()



        binding.button3.setOnClickListener {
            Res.numero = binding.text.text.toString()
            val bundle = bundleOf("Result" to Res)
            if(Res.numero!!.toInt() <= 0 ){
                binding.button3.setBackgroundColor(5)
            }
            findNavController().navigate(R.id.action_numero_to_type,bundle )
        }
        binding.button2.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}