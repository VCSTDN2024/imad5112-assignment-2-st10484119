package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val StartBtn = findViewById<Button>(R.id.StartBtn)
        val ExtBtn = findViewById<Button>(R.id.ExtBtn)

        ExtBtn.setOnClickListener(){
            finishAffinity()
            exitProcess(0)

        }
        StartBtn.setOnClickListener(){
        val Intent = Intent(this, Questions::class.java)
            startActivity(Intent)

        }

        }


    }
