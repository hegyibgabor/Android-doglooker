package com.example.beadando_joiad3.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class viewModel : ViewModel() {
    private var repository: Repository? = null
    var getAllDogs: LiveData<List<apiModel?>?>? = null

    fun DogViewModel(application: Application?) {

        repository = Repository(application)
        getAllDogs = repository!!.getAllDogs
    }

    fun insert(dogs: List<apiModel?>?) {
        repository!!.insert(dogs)
    }

    fun getAllDogs(): LiveData<List<apiModel?>?>? {
        return getAllDogs
    }

}