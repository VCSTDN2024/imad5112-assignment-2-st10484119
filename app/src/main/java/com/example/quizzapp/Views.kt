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

private lateinit var closeBtn : Button
private lateinit var repeat : Button
private lateinit var reviewTextView: TextView


class Views : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_views)

        closeBtn = findViewById(R.id.closeBtn)
        repeat = findViewById(R.id.repeat)
        reviewTextView = findViewById(R.id.reviewTextView)

        closeBtn.setOnClickListener() {
            finishAffinity()
            exitProcess(0)
        }

        repeat.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size){
            for (i in questions.indices) {
                reviewText.append("${i + 1}, ${questions[i]}\n")
                reviewText.append("  Answer: ${if (answers[i])  "True" else "False" }\n")

            }
            reviewTextView.text = reviewText.toString()
        } else {
            reviewTextView.text = "error loading review data"
        }




    }


}








