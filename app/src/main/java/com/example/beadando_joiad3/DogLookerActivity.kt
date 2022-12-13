package com.example.beadando_joiad3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DogLookerActivity : AppCompatActivity() {
    lateinit var firstFragmentBtn : Button;
    lateinit var secondFragmentBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looker)

        val breedName: TextView = findViewById(R.id.mainTitle)



        val bundle: Bundle? = intent.extras
        val dogImages = bundle!!.getInt("dogImages")
        val dogBreeds = bundle.getString("breed_name")

        breedName.text = dogBreeds

        val intent  = Intent(this@DogLookerActivity,info::class.java)
        intent.putExtra("breed_name",dogBreeds)



    }




}