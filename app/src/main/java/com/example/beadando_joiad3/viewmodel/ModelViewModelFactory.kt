package com.example.beadando_joiad3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beadando_joiad3.remote.Repository

class ModelViewModelFactory constructor(val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if(modelClass.isAssignableFrom(DogViewModel::class.java))
        {
            DogViewModel(this.repository) as T
        }
        else
        {
            throw IllegalArgumentException("view model not found")
        }
    }
}