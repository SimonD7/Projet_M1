package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

/***
 * notre apllication comporte plusieur fragements
 * qui partagent entre eux une valeur qui represente une instance  de la classe cree en result
 * "Result"
 */

class MainActivity : AppCompatActivity () {
    override fun onCreate( savedInstanceState : Bundle ?) {
        super.onCreate(savedInstanceState )
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView ( binding.root )
    }
}

