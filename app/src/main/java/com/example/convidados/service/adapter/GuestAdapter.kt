package com.example.convidados.service.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel

class GuestAdapter(val guests: List<GuestModel>) :
    RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(guest: GuestModel) {
            with(guest) {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guest, parent, false)
        return GuestViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val objeto = guests[position]
        holder.bind(objeto)
    }

    override fun getItemCount(): Int {
        return guests.size
    }

}