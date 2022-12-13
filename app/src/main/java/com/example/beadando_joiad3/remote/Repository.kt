package com.example.beadando_joiad3.remote

class Repository(private val retrofitService: RetrofitService) {

    suspend fun getPhotos()=retrofitService.getImg()

}