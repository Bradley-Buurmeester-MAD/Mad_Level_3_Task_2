package com.example.madlevel3task2

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*
import kotlin.math.log

class PortalAdapter (private val portals: List<Portal>, private val clickListener: (Portal) -> Unit):
RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {

        fun databind(portal: Portal, clickListener: (Portal) -> Unit){
            itemView.tvTitle.text = portal.title
            itemView.tvLink.text = portal.link

            itemView.setOnClickListener {
                clickListener(portal)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(portals[position], clickListener)
    }

    override fun getItemCount(): Int {
        return portals.size
    }
}