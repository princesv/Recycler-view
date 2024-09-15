package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class ColorListAdapter(val mList: List<String>): RecyclerView.Adapter<ColorListAdapter.ViewHolder>() {
    private lateinit var onClickListener: onListItemClickListener
    public interface onListItemClickListener{
        fun onClickListener(position: Int)
    }
    fun setOnItemClickListenerFromMainActivity(listener: onListItemClickListener){
        onClickListener=listener
    }
    inner class ViewHolder(itemView: View,val listener: onListItemClickListener): RecyclerView.ViewHolder(itemView){
            val colotTv = itemView.findViewById<TextView>(R.id.color_name)
        init {
            itemView.setOnClickListener{
                listener.onClickListener(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view,onClickListener)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.colotTv.setText(mList.get(position))
    }
}