package com.gcendon.primerparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tv_nombre)
        private val dificultad: TextView = view.findViewById(R.id.tv_dificultad)
        private val logo: ImageView = view.findViewById(R.id.iv_logo)
        private val bandera: ImageView = view.findViewById(R.id.iv_bandera)

        fun bind(receta: Receta) {
            nombre.text = receta.nombre
            dificultad.text = receta.dificultad
            val imagen = when (receta.pais) {
                Pais.ARGENTINA -> R.drawable.arg
                Pais.BRASIL -> R.drawable.bra
                Pais.PERU -> R.drawable.per
                Pais.URUGUAY -> R.drawable.uru
            }
            bandera.setImageResource(imagen)
            Glide.with(context).load(receta.logo).into(logo)

            view.setOnClickListener {
                onItemClickListener(receta)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val receta = getItem(position)
        holder.bind(receta)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}