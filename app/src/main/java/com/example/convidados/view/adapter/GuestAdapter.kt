package com.example.convidados.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.item_guest.view.*

class GuestAdapter(val guests: List<GuestModel>) :
    RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(guest: GuestModel) {
            with(guest) {
                itemView.text_item_name.setText(name)
                itemView.text_item_presence.setText(if(presence)"Presente" else "Ausente")
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