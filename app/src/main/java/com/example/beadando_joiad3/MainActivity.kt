package com.example.beadando_joiad3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById (R.id.startButton)

        startButton.setOnClickListener() {
            val intent = Intent(this, DogListActivity   ::class.java)
            startActivity(intent)
        }

        }
    }