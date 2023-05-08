package com.example.a5week_memo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5week_memo.databinding.ItemDataBinding


class RVAdapter(
    private val dataList: ArrayList<Data>,
    val onClickDeleteBtn: (data: Data) -> Unit):
    RecyclerView.Adapter<RVAdapter.DataViewHolder>() {
    // ViewHolder 객체
    inner class DataViewHolder(val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.tvMemo.text = data.memo;
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val listposition = dataList[position]
        holder.bind(listposition)
        // deleteBtn 이 눌렸을 때 position 전달
        holder.binding.btnDelete.setOnClickListener {
            onClickDeleteBtn.invoke(listposition)
        }
    }

    // 표현할 Item 의 총 개수
    override fun getItemCount(): Int = dataList.size
}