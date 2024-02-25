package com.example.aplicaciontanteo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import android.widget.Button
class MainActivity : AppCompatActivity(){
    private lateinit var viewModel: PuntajeViewModel
    private lateinit var arregloLocal: IntArray
    private lateinit var arregloVisitante: IntArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PuntajeViewModel::class.java)

        var verPuntosLocalTotal : TextView = findViewById(R.id.etnLocalTotal)
        var verPuntosLocalUno : TextView = findViewById(R.id.etnCounterLocal1)
        var verPuntosLocalDos : TextView = findViewById(R.id.etnCounterLocal2)
        var verPuntosLocalTres : TextView = findViewById(R.id.etnCounterLocal3)

        var verPuntosVisitanteTotal : TextView = findViewById(R.id.etnVisitanteTotal)
        var verPuntosVisitanteUno : TextView = findViewById(R.id.etnCounterVisitante1)
        var verPuntosVisitanteDos : TextView = findViewById(R.id.etnCounterVisitante2)
        var verPuntosVisitanteTres : TextView = findViewById(R.id.etnCounterVisitante3)

        val botonMas1L : Button = findViewById(R.id.bMasUnoLocal)
        val botonMas2L : Button = findViewById(R.id.bMasDosLocal)
        val botonMas3L : Button = findViewById(R.id.bMasTresLocal)

        val botonMas1V : Button = findViewById(R.id.bMasUnoVisitante)
        val botonMas2V : Button = findViewById(R.id.bMasDosVisitante)
        val botonMas3V : Button = findViewById(R.id.bMasTresVisitante)


        verPuntosLocalTotal.text = viewModel.puntosLocalTotal.toString()
        verPuntosLocalUno.text = viewModel.puntosLocalUno.toString()
        verPuntosLocalDos.text = viewModel.puntosLocalDos.toString()
        verPuntosLocalTres.text = viewModel.puntosLocalTres.toString()

        verPuntosVisitanteTotal.text = viewModel.puntosVisitanteTotal.toString()
        verPuntosVisitanteUno.text = viewModel.puntosVisitanteUno.toString()
        verPuntosVisitanteDos.text = viewModel.puntosVisitanteDos.toString()
        verPuntosVisitanteTres.text = viewModel.puntosVisitanteTres.toString()

         //listeners de botones
        botonMas1L.setOnClickListener{
            viewModel.incrementaEquipoLocalUno()
            verPuntosLocalUno.text = viewModel.puntosLocalUno.toString()
            verPuntosLocalTotal.text = viewModel.puntosLocalTotal.toString()
        }

        botonMas2L.setOnClickListener{
            viewModel.incrementaEquipoLocalDos()
            verPuntosLocalDos.text = viewModel.puntosLocalDos.toString()
            verPuntosLocalTotal.text = viewModel.puntosLocalTotal.toString()
        }

        botonMas3L.setOnClickListener{
            viewModel.incrementaEquipoLocalTres()
            verPuntosLocalTres.text = viewModel.puntosLocalTres.toString()
            verPuntosLocalTotal.text = viewModel.puntosLocalTotal.toString()
        }

        botonMas1V.setOnClickListener {
            viewModel.incrementaEquipoVisitanteUno()
            verPuntosVisitanteUno.text = viewModel.puntosVisitanteUno.toString()
            verPuntosVisitanteTotal.text = viewModel.puntosVisitanteTotal.toString()
        }

        botonMas2V.setOnClickListener {
            viewModel.incrementaEquipoVisitanteDos()
            verPuntosVisitanteDos.text = viewModel.puntosVisitanteDos.toString()
            verPuntosVisitanteTotal.text = viewModel.puntosVisitanteTotal.toString()
        }

        botonMas3V.setOnClickListener {
            viewModel.incrementaEquipoVisitanteTres()
            verPuntosVisitanteTres.text = viewModel.puntosVisitanteTres.toString()
            verPuntosVisitanteTotal.text = viewModel.puntosVisitanteTotal.toString()
        }

    }
    fun irEstadistica(view: View){
        viewModel = ViewModelProvider(this).get(PuntajeViewModel::class.java)
        val intent = Intent(this, MainActivity2::class.java)
        // creamos un bundle para mandar datos
        val bundle = Bundle()
        //ponemos datos en un arreglo local
        arregloLocal = intArrayOf(viewModel.puntosLocalUno,viewModel.puntosLocalDos,viewModel.puntosLocalTres)
        arregloVisitante = intArrayOf(viewModel.puntosVisitanteUno,viewModel.puntosVisitanteDos,viewModel.puntosVisitanteTres)
        bundle.putIntArray("LocalPuntaje",arregloLocal)
        bundle.putIntArray("VisitantePuntaje",arregloVisitante)
        //insertamos bundle en el Intent
        intent.putExtras(bundle)
        //empezamos actividad deseada
        startActivity(intent)
    }
}

