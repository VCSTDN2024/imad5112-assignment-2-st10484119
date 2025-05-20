package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess


private lateinit var results :TextView
private lateinit var comment : TextView
private lateinit var review : Button
private lateinit var ExitBtn : Button
private lateinit var result : TextView



class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        review = findViewById(R.id.review)
        ExitBtn = findViewById(R.id.ExitBtn)
        comment = findViewById(R.id.comment)
        results = findViewById(R.id.Result)
        val scores = intent.getIntExtra("score", 0)
        results.text = "Your score is $scores / 5"

        val feedback = if (scores >= 3) {
            "You have good ball knowledge"

        } else {
            "Better luck next time"
        }

        comment.text = feedback

        ExitBtn.setOnClickListener() {
            finishAffinity()
            exitProcess(0)
        }
       review.setOnClickListener(){
           val intent = Intent(this, Views::class.java)
           intent.putExtra("questions", questions)
           intent.putExtra("answers", answers)
           startActivity(intent)
           finish()
           }


    }
}
