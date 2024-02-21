package com.example.aplicaciontanteo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {

    companion object {
        fun conseguirValores(intent: Intent): IntArray? {
            val bundle = intent.extras
            val TAG = "MainActivity2"

            if (bundle != null){
                Log.i(TAG,"Se encontro Informacion!")
                val LocalArreglo = bundle.getIntArray("LocalPuntaje")
                return LocalArreglo
            } else {
                Log.i(TAG,"No se encontro Informacion")
                return intArrayOf(0,0,0,0)
            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val localArreglo = Companion.conseguirValores(intent)
        setContentView(R.layout.activity_main2)
    }




}