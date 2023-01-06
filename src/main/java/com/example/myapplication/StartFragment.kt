package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.StartBinding

/**
 * ce fragement represente le premier fragement de notre application et qui
 * emmene vers les autre fragement qui collectent les donnes
 */
class StartFragment:Fragment(){
    private lateinit var binding : StartBinding

    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = StartBinding.inflate ( inflater )

        return binding.root

    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_start_to_voie )
        }
    }

}