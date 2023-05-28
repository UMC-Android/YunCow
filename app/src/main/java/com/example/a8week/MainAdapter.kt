package com.example.a8week

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MainAdapter(private val memo: List<Memo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_memoitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(memo[position])
    }

    override fun getItemCount(): Int = memo.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Title = itemView?.findViewById<TextView>(R.id.tv_memotext)

        fun bind(memo: Memo) {
            Title?.text = memo.title
        }
    }
}