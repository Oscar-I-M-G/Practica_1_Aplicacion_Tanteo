package com.example.aplicaciontanteo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var puntosLocalTotal = 0
    private var puntosLocalUno = 0
    private var puntosLocalDos = 0
    private var puntosLocalTres = 0


    private var puntosVisitanteTotal = 0
    private var puntosVisitanteUno = 0
    private var puntosVisitanteDos = 0
    private var puntosVisitanteTres = 0

    private lateinit var verPuntosLocalTotal : TextView
    private lateinit var verPuntosLocalUno : TextView
    private lateinit var verPuntosLocalDos: TextView
    private lateinit var verPuntosLocalTres : TextView

    private lateinit var verPuntosVisitanteTotal : TextView
    private lateinit var verPuntosVisitanteUno : TextView
    private lateinit var verPuntosVisitanteDos : TextView
    private lateinit var verPuntosVisitanteTres : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verPuntosLocalTotal = findViewById(R.id.etnLocalTotal)
        verPuntosLocalUno = findViewById(R.id.etnCounterLocal1)
        verPuntosLocalDos = findViewById(R.id.etnCounterLocal2)
        verPuntosLocalTres = findViewById(R.id.etnCounterLocal3)



        verPuntosVisitanteTotal = findViewById(R.id.etnVisitanteTotal)
        verPuntosVisitanteUno = findViewById(R.id.etnCounterVisitante1)
        verPuntosVisitanteDos = findViewById(R.id.etnCounterVisitante2)
        verPuntosVisitanteTres = findViewById(R.id.etnCounterVisitante3)
    }

    fun incrementaEquipoLocalUno(view: View){
        puntosLocalUno ++
        mostrarPuntos()
    }

    fun incrementaEquipoLocalDos(view: View){
        puntosLocalDos ++
        mostrarPuntos()
    }
    fun incrementaEquipoLocalTres(view: View){
        puntosLocalTres ++
        mostrarPuntos()
    }

    fun incrementaEquipoVisitanteUno(view: View){
        puntosVisitanteUno ++
        mostrarPuntos()
    }

    fun incrementaEquipoVisitanteDos(view: View){
        puntosVisitanteDos ++
        mostrarPuntos()
    }
    fun incrementaEquipoVisitanteTres(view: View){
        puntosVisitanteTres ++
        mostrarPuntos()
    }

    private fun mostrarPuntos() {
        puntosLocalTotal = puntosLocalUno + (puntosLocalDos * 2) + (puntosLocalTres * 3)
        verPuntosLocalUno.text = puntosLocalUno.toString()
        verPuntosLocalDos.text = puntosLocalDos.toString()
        verPuntosLocalTres.text = puntosLocalTres.toString()
        verPuntosLocalTotal.text = puntosLocalTotal.toString()

        puntosVisitanteTotal = puntosVisitanteUno + (puntosVisitanteDos * 2) + (puntosVisitanteTres * 3)
        verPuntosVisitanteUno.text = puntosVisitanteUno.toString()
        verPuntosVisitanteDos.text = puntosVisitanteDos.toString()
        verPuntosVisitanteTres.text = puntosVisitanteTres.toString()
        verPuntosVisitanteTotal.text = puntosVisitanteTotal.toString()

    }

    fun irEstadistica(view: View){
        val intent = Intent(this, MainActivity2::class.java)
        // creamos un bundle para mandar datos
        val bundle = Bundle()
        //ponemos datos en un arreglo local
        val arregloLocal = intArrayOf(puntosLocalUno,puntosLocalDos,puntosLocalTres)
        bundle.putIntArray("LocalPuntaje",arregloLocal)
        //insertamos bundle en el Intent
        intent.putExtras(bundle)
        //empezamos actividad deseada
        startActivity(intent)
    }

}

