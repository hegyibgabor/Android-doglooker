package com.example.beadando_joiad3

import androidx.recyclerview.widget.DiffUtil
import com.example.beadando_joiad3.model.DogModel

class ListDiffUtil(
    private val oldList: ArrayList<DogModel>,
    private val newList: ArrayList<DogModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].img == newList[newItemPosition].img
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].img != newList[newItemPosition].img -> {
                false
            }
            oldList[oldItemPosition].breedName != newList[newItemPosition].breedName -> {
                false
            }
            else -> true
        }
    }


}