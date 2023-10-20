package com.gcendon.primerparcial

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(){
 private lateinit var tvNombreDetail: TextView
 private lateinit var tvIngredientes: TextView
 private lateinit var ivLogo: ImageView
 private lateinit var tvDescripcion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        tvNombreDetail = findViewById(R.id.tv_nombre_detail)
        tvIngredientes = findViewById(R.id.tv_ingredientes_detail)
        ivLogo = findViewById(R.id.iv_logo_detail)
        tvDescripcion = findViewById(R.id.tv_descripcion)

        tvNombreDetail.text = receta?.nombre
        tvDescripcion.text = receta?.descripcion
        tvIngredientes.text = receta?.ingredientes.toString()


        Glide.with(this).load(receta?.logo).into(ivLogo)
    }
}