package com.example.beadando_joiad3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beadando_joiad3.model.ApiModel
import com.example.beadando_joiad3.remote.Repository
import kotlinx.coroutines.*

class DogViewModel constructor(private val repository: Repository):ViewModel(){

    val dogPhotoList = MutableLiveData<List<ApiModel>>()
    val errormsg = MutableLiveData<String>()
    var handlejob: Job? = null

    val loading = MutableLiveData<Boolean>()

    val exceptionHandler= CoroutineExceptionHandler{_,throwable->onError(

        "Exception :${throwable.localizedMessage}"
    )

    }

    private fun onError(msg: String) {

    errormsg.postValue(msg)
        loading.postValue(false)

    }

    override fun onCleared() {
        super.onCleared()

        handlejob?.cancel()
    }

    fun getPhotos()
    {
        handlejob = CoroutineScope(Dispatchers.IO+exceptionHandler).launch{
            val response = repository.getPhotos()
            withContext((Dispatchers.Main)){
                if(response.isSuccessful){
                    dogPhotoList.postValue(response.body())

                    loading.value = false
                }
                else{
                    onError("Hibakód:${response.message()}")
                }
            }
        }


    }




}