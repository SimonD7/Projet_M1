package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.ResultBinding
import com.example.myapplication.result.Result
import com.example.myapplication.result.ResultRep
import com.example.myapplication.view.viewModel


class  ResultFragement:Fragment(){
    private lateinit var binding :ResultBinding
    private lateinit var Res : Result
    val MyViewModel : viewModel by viewModels()

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
        binding = ResultBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        MyViewModel.estime(Res.numero!!,Res.type!!,Res.surfaceb!!,Res.Piece!!,Res.surfacet!!,Res.longitude!!,Res.latitude!!)
        binding.textView.text = Res.numero.toString()

        MyViewModel.r.observe(viewLifecycleOwner){value ->
            when (value ){
                is ResultRep.Estimed -> binding.textView.text = getString(R.string.result,value.result)

                else -> {}
            }

            }




        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_fin_to_voie)
        }

    }


}