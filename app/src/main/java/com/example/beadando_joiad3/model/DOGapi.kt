package com.example.beadando_joiad3.model
import android.graphics.ColorSpace.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface DOGapi {
    @GET("search")
    fun getImgs(@Query("limit") limit: Int): Call<List<apiModel?>?>?
}