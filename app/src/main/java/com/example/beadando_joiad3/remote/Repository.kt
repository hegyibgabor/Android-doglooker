package com.example.beadando_joiad3.remote

import android.util.Log

class Repository(private val retrofitService: RetrofitService) {

    suspend fun getPhotos()=retrofitService.getImg()


}