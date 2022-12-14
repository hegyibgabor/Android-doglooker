package com.example.beadando_joiad3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.databinding.ItemPicBinding
import com.example.beadando_joiad3.model.ApiModel
import com.squareup.picasso.Picasso

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>(){


    //Nem a modelből kéne lehet kiolvasni hanem külön egy listába elmenteni az egészet, de hátha így is
    var photolist= mutableListOf<ApiModel>()

    class PhotoViewHolder(val binding : ItemPicBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        val inflator = LayoutInflater.from(parent.context)
        val binding = ItemPicBinding.inflate(inflator, parent , false )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val dog = photolist[position]
        Picasso.get().load(dog.message).into(holder.binding.itempic)
    }

    override fun getItemCount(): Int {
        return photolist.size
    }
    fun setPhotos(photo : List<ApiModel>){
        this.photolist =  photo.toMutableList()
        notifyDataSetChanged()
    }
}