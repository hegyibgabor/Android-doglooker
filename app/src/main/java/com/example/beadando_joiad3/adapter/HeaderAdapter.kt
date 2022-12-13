package com.example.beadando_joiad3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.ListDiffUtil
import com.example.beadando_joiad3.R
import com.example.beadando_joiad3.model.DogModel

class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>(){
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val dogNumberTextView: TextView = itemView.findViewById(R.id.headerInfoTextView1)

        fun bind(dogCount: Int) {
            dogNumberTextView.text = dogCount.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_header, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(dogCount = 15)
    }

    override fun getItemCount(): Int {
        return 1
    }


}