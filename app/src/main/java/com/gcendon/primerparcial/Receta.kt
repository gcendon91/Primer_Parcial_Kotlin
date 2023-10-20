package com.gcendon.primerparcial

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Receta(
    val id: Int,
    val nombre: String,
    val pais: Pais,
    val dificultad: String,
    val logo: String,
    val ingredientes: String,
    val descripcion: String
):Parcelable

enum class Pais {
    ARGENTINA,
    BRASIL,
    PERU,
    URUGUAY
}