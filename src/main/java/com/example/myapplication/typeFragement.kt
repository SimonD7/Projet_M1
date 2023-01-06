package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.TypeBinding
import com.example.myapplication.result.Result

class  typeFragement:Fragment(){
    private lateinit var binding : TypeBinding
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
        binding = TypeBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )



        binding.button3.setOnClickListener {
            if(binding.spinner.getSelectedItem().toString().isEmpty() ) {
                Toast.makeText(context,"il faut remplir tous les champs", Toast.LENGTH_LONG).show()

            } else {
            Res.type = binding.spinner.getSelectedItem().toString();
            val bundle = bundleOf("Result" to Res)
            findNavController().navigate(R.id.action_type_to_surface ,bundle)
            }
        }
        binding.button2.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}