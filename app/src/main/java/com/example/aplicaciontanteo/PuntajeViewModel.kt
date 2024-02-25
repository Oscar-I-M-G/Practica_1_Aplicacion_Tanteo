package com.example.aplicaciontanteo

import androidx.lifecycle.ViewModel

class PuntajeViewModel : ViewModel(){
    var puntosLocalTotal = 0
    var puntosLocalUno = 0
    var puntosLocalDos = 0
    var puntosLocalTres = 0


    var puntosVisitanteTotal = 0
    var puntosVisitanteUno = 0
    var puntosVisitanteDos = 0
    var puntosVisitanteTres = 0

    fun incrementaEquipoLocalUno(){
        puntosLocalUno ++
        mostrarPuntos()
    }
    fun incrementaEquipoLocalDos(){
        puntosLocalDos ++
        mostrarPuntos()
    }
    fun incrementaEquipoLocalTres(){
        puntosLocalTres ++
        mostrarPuntos()
    }
    fun incrementaEquipoVisitanteUno(){
        puntosVisitanteUno ++
        mostrarPuntos()
    }
    fun incrementaEquipoVisitanteDos(){
        puntosVisitanteDos ++
        mostrarPuntos()
    }
    fun incrementaEquipoVisitanteTres(){
        puntosVisitanteTres ++
        mostrarPuntos()
    }
    fun mostrarPuntos() {
        puntosLocalTotal = puntosLocalUno + (puntosLocalDos * 2) + (puntosLocalTres * 3)
        puntosVisitanteTotal = puntosVisitanteUno + (puntosVisitanteDos * 2) + (puntosVisitanteTres * 3)
    }
}