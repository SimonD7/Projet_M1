package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.VoieBinding
import com.example.myapplication.result.Result

/**
 * voici notre premier fragement de collecte de donnes .
 */


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

            /**
             * verifier si les deux champs sons bien remplis
             */
            if(binding.text1.text.toString().isEmpty() || binding.text2.text.toString().isEmpty() ) {

                Toast.makeText(context,"il faut remplir tous les champs",Toast.LENGTH_LONG).show()

            } else {
                /**
                 * stocker les donne dans notre Result pour le passer on argument aux autres fragements
                 */
                val voie_name = Result(
                    binding.text1.text.toString().toDouble(),
                    binding.text2.text.toString().toDouble(),
                    null,
                    null,
                    null,
                    null,
                    null
                )

                val bundle = bundleOf("Result" to voie_name)
                findNavController().navigate(R.id.action_voie_to_numero, bundle)
            }
        }

    }

}