package com.example.beadando_joiad3.model

import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.beadando_joiad3.Dog_RecyclerViewAdapter
import com.example.beadando_joiad3.R
import com.squareup.picasso.Picasso


class DogPhotoAdapter(private val dogs : ArrayList<apiModel>): RecyclerView.Adapter<DogPhotoAdapter.DogPhotoViewHolder>() {

    class DogPhotoViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var dogPicImgViewer: ImageView = itemView.findViewById(R.id.itempic);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogPhotoViewHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false)
        return DogPhotoAdapter.DogPhotoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DogPhotoViewHolder, position: Int) {
        var dog = dogs.get(position)
        Picasso.get().load(dog.url).into(holder.dogPicImgViewer);
    }

    override fun getItemCount(): Int {
        return dogs.size
    }




}