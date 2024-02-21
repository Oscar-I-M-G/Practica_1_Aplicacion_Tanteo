package com.example.aplicaciontanteo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import java.security.Key

class MainActivity2 : AppCompatActivity() {
    private lateinit var localArreglo : IntArray
    private lateinit var progressLocal1 : TextView
    private lateinit var progressLocal2 : TextView
    private lateinit var progressLocal3 : TextView
    private lateinit var pbLocal1 : ProgressBar
    private lateinit var pbLocal2 : ProgressBar
    private lateinit var pbLocal3 : ProgressBar

    private lateinit var visitanteArreglo : IntArray
    private lateinit var progressVisitante1 : TextView
    private lateinit var progressVisitante2 : TextView
    private lateinit var progressVisitante3 : TextView
    private lateinit var pbVisitante1 : ProgressBar
    private lateinit var pbVisitante2 : ProgressBar
    private lateinit var pbVisitante3 : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        localArreglo = conseguirValores(intent,"LocalPuntaje")
        progressLocal1 = findViewById(R.id.tvPuntos1Local)
        progressLocal2 = findViewById(R.id.tvPuntos2Local)
        progressLocal3 = findViewById(R.id.tvPuntos3Local)
        pbLocal1 = findViewById(R.id.pbTiros1Local)
        pbLocal2 = findViewById(R.id.pbTiros2Local)
        pbLocal3 = findViewById(R.id.pbTiros3Local)
        visitanteArreglo = conseguirValores(intent,"VisitantePuntaje")
        progressVisitante1 = findViewById(R.id.tvPuntos1Visitante)
        progressVisitante2 = findViewById(R.id.tvPuntos2Visitante)
        progressVisitante3= findViewById(R.id.tvPuntos3Visitante)
        pbVisitante1 = findViewById(R.id.pbTiros1Visitante)
        pbVisitante2 = findViewById(R.id.pbTiros2Visitante)
        pbVisitante3 = findViewById(R.id.pbTiros3Visitante)
        mostrarProgreso()
 }

    private fun getPercentageShot (arregloTiros: IntArray, queTiro: Int):Int?{
        val totalTiros = arregloTiros[0] + arregloTiros[1] + arregloTiros [2]
        val percentNow = (arregloTiros[queTiro] * 100) / totalTiros
        return percentNow
    }
    private fun conseguirValores(intent: Intent, queArreglo: String): IntArray{
        val bundle = intent.extras
        val TAG = "MainActivity2"

        if (bundle != null){
            Log.i(TAG,"Se encontro Informacion!")
            val arregloMandar = bundle.getIntArray(queArreglo)
            return arregloMandar ?: intArrayOf(0,0,0)
        } else {
            Log.i(TAG,"No se encontro Informacion")
            return intArrayOf(0,0,0)
        }

    }
    private fun mostrarProgreso () {
        progressLocal1.text = localArreglo!![0].toString()
        progressLocal2.text = localArreglo!![1].toString()
        progressLocal3.text = localArreglo!![2].toString()

        pbLocal1.progress = getPercentageShot(localArreglo,0)!!.toInt()
        pbLocal2.progress = getPercentageShot(localArreglo,1)!!.toInt()
        pbLocal3.progress = getPercentageShot(localArreglo,2)!!.toInt()

        progressVisitante1.text = visitanteArreglo!![0].toString()
        progressVisitante2.text = visitanteArreglo!![1].toString()
        progressVisitante3.text = visitanteArreglo!![2].toString()

        pbVisitante1.progress = getPercentageShot(visitanteArreglo,0)!!.toInt()
        pbVisitante2.progress = getPercentageShot(visitanteArreglo,1)!!.toInt()
        pbVisitante3.progress = getPercentageShot(visitanteArreglo,2)!!.toInt()


    }




}