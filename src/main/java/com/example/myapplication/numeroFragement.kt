package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            /**
             * verifier si les  champs sons bien remplis
             */
            if(binding.text.text.toString().isEmpty()  ) {
                Toast.makeText(context,"il faut remplir tous les champs", Toast.LENGTH_LONG).show()

            } else {
                /**
                 * stocker les donne dans notre Result pour le passer on argument aux autres fragements
                 */
                Res.numero = binding.text.text.toString().toInt()
                val bundle = bundleOf("Result" to Res)

                findNavController().navigate(R.id.action_numero_to_type, bundle)
            }
        }
        binding.button2.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}