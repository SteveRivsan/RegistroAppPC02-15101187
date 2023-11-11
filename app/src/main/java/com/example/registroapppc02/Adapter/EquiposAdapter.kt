package com.example.registroapppc02.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registroapppc02.Adapter.EquiposAdapter.ViewHolder
import com.example.registroapppc02.Modelos.Equipos
import com.example.registroapppc02.R
import com.squareup.picasso.Picasso

class EquiposAdapter(private var lstEquipos: List<Equipos>): RecyclerView.Adapter<ViewHolder>()  {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvAño: TextView = itemView.findViewById(R.id.tvAño)
        val tvTitulos: ImageView = itemView.findViewById(R.id.tvTitulos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_equipos, parent, false))
    }

    override fun getItemCount(): Int {
        return lstEquipos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemEquipos = lstEquipos[position]
        holder.tvNombre.text = itemEquipos.NombreEquipo
        holder.tvAño.text = itemEquipos.Año
        Picasso.get().load(itemEquipos.imageUrl).into(holder.)
    }
}