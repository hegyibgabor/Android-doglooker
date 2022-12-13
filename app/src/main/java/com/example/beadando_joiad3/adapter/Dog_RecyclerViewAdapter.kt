package com.example.beadando_joiad3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.R
import com.example.beadando_joiad3.model.DogModel
import kotlin.collections.ArrayList

class Dog_RecyclerViewAdapter(private val dogsList : ArrayList<DogModel>): RecyclerView.Adapter<Dog_RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var mListener: onitemClickListener

    interface onitemClickListener{

        fun onItemClick(position : Int)
    }

    fun setOnitemClickListener(listener: onitemClickListener){

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Kinézet
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false)

        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Value assign
        val currentItem = dogsList[position]
        holder.textView.setText(currentItem.breedName)
        holder.imageView.setImageResource(currentItem.img)
    }

    override fun getItemCount(): Int {
        //mennyi legyen kiírva
        return dogsList.size;
    }

    class MyViewHolder(itemView: View, listener: onitemClickListener) : RecyclerView.ViewHolder(itemView) {

         var imageView: ImageView = itemView.findViewById(R.id.imageView);
         var textView: TextView = itemView.findViewById(R.id.breedNameTextView);

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }

        }
    }


}