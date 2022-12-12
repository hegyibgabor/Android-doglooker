package com.example.beadando_joiad3.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.databinding.ItemPicBinding
import com.example.beadando_joiad3.model.APIModel
import com.squareup.picasso.Picasso

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){


    var photolist= mutableListOf<APIModel>()

    class PhotoViewHolder(val binding : ItemPicBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        val inflator = LayoutInflater.from(parent.context)
        val binding = ItemPicBinding.inflate(inflator, parent , false )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val dog = photolist[position]
        Picasso.get().load(dog.message[position]).into(holder.binding.itempic)
    }

    override fun getItemCount(): Int {
        return photolist.size
    }
    fun setPhotos(photo : List<APIModel>){
        this.photolist =  photo.toMutableList()
        notifyDataSetChanged()
    }
}