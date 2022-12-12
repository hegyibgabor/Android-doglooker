package com.example.beadando_joiad3.remote

import com.example.beadando_joiad3.model.APIModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("breed/hound/images/random/15")
    suspend fun getImg():Response<List<APIModel>>

    companion object {
        var retrofitService:RetrofitService?=null

        fun getInstance():RetrofitService{

            if(retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dog.ceo/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}