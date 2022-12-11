package com.example.beadando_joiad3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import androidx.navigation.findNavController

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

        breedName.setText(dogBreeds)




    }



}