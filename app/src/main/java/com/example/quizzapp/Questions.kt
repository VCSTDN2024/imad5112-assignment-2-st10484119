package com.example.quizzapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess



private lateinit var question : TextView
private lateinit var TrueBtn : Button
private lateinit var FalseBtn : Button
private lateinit var BtnExt : Button
private lateinit var NextQuestion : Button
private lateinit var Feedback : TextView


    val questions = arrayOf(
        "Liverpool have won 20 premier leagues",
        "Arsenal won the 24/25 season",
        "Real Madrid have not won a trophy this season",
        "AC Milan finished below Inter Milan this season",
        "Mikel Arteta has not  won a trophy with Arsenal",

    )
    val answers = booleanArrayOf(false, false, true, true, true)

private var currentQuestionsIndex = 0
private var scores = 0


class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)






        BtnExt = findViewById(R.id.BtnExt)
        FalseBtn = findViewById(R.id.FalseBtn)
        TrueBtn = findViewById(R.id.TrueBtn)
        question = findViewById(R.id.question)
        NextQuestion = findViewById(R.id.NextQuestion)
        Feedback = findViewById(R.id.Feedback)


question.text = questions[currentQuestionsIndex]



        fun displayQuestion() {
            question.text = questions[currentQuestionsIndex]

        }

        fun CheckAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentQuestionsIndex]

            if (userAnswer == correctAnswer) {
                Feedback.text = "Correct !"
                Feedback.setTextColor(Color.GREEN)
                scores++
            } else {
                Feedback.text = "Incorrect :( "
                Feedback.setTextColor(Color.RED)
            }
            TrueBtn.isEnabled = false
            FalseBtn.isEnabled = false
            NextQuestion.isEnabled = true

        }

        TrueBtn.setOnClickListener {
            CheckAnswer(true)}
            FalseBtn.setOnClickListener { CheckAnswer(false) }



            NextQuestion.setOnClickListener {
                currentQuestionsIndex++
                if (currentQuestionsIndex < questions.size) {
                    displayQuestion()
                    TrueBtn.isEnabled = true
                    FalseBtn.isEnabled = true
                    Feedback.text = ""

                } else {

                val intent = Intent(this, Review::class.java)
                intent.putExtra("score", scores)
                    intent.putExtra("questions", questions)
                    intent.putExtra("answers", answers)
                startActivity(intent)
                finish()}
            }









            BtnExt.setOnClickListener() {
                finishAffinity()
                exitProcess(0)
            }



    }
}



