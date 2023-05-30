package com.example.a9week_api2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TuttleAdapter(items: List<TuttleList>) :
    RecyclerView.Adapter<TuttleAdapter.ViewHolder>() {
    private val items: List<TuttleList>

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: TuttleList = items[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var spcKrNm: TextView = itemView.findViewById(R.id.spcKrNm)
        private var dschrAcqtLcNm: TextView = itemView.findViewById(R.id.dschrAcqtLcNm)

        fun setItem(item: TuttleList) {
            spcKrNm.text = item.spcKrNm
            dschrAcqtLcNm.text = item.dschrAsqsLcNm

        }
    }
}