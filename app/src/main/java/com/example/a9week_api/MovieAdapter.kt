package com.example.a9week_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a9week_api.DailyBoxOfficeList


class MovieAdapter(items: List<DailyBoxOfficeList>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val items: List<DailyBoxOfficeList>

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: DailyBoxOfficeList = items[position]
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var rank: TextView = itemView.findViewById(R.id.rank)
        private var movieNm: TextView = itemView.findViewById(R.id.movieNM)
        private var openDt: TextView = itemView.findViewById(R.id.openDt)

        fun setItem(item: DailyBoxOfficeList) {
            rank.text = item.rank
            movieNm.text = item.movieNm
            openDt.text = item.openDt
        }
    }
}