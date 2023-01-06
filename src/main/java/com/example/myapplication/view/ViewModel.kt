package com.example.myapplication.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.backend.backend

import com.example.myapplication.result.ResultRep

class viewModel  (state : SavedStateHandle) : ViewModel() {
    private val myBackend = backend()
    private val _Result : MutableLiveData<ResultRep> = state.getLiveData( "stateResult" , ResultRep.NotEstimed )
    val r : LiveData<ResultRep> = _Result

    fun estime(adresse_numero: Int, type_local: String, surface_reelle_bati: Int, nombre_pieces_principales: Int, surface_terrain: Int, longitude: Double, latitude: Double) {
        println(adresse_numero.toString()+ " "+type_local+ " "+surface_reelle_bati.toString()+ " "+nombre_pieces_principales.toString()+ " "+surface_terrain.toString()+ " "+longitude.toString()+ " "+latitude.toString())
        _Result.value = ResultRep.Estimed(myBackend.estimation(adresse_numero,type_local,surface_reelle_bati,nombre_pieces_principales,surface_terrain,longitude,latitude))
    }
}