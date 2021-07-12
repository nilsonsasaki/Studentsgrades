package com.nilsonSasaki.studentsgrades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btResult:Button = Calculate
        val tvResult:TextView = DisplayResult

        btResult.setOnClickListener{

            val score1:Int= Integer.parseInt(Exam1.text.toString())
            val score2:Int= Integer.parseInt(Exam2.text.toString())
            val average = (score1 + score2)/2.0
            val abstention = Integer.parseInt(Absences.text.toString())

            if(average>=6 && abstention<=10){
                tvResult.setText("Student is approved" + "\n"+ "Final Grade: " + average + "\n" + "Absences: " + abstention)
            } else {
                tvResult.setText("Student is reproved" + "\n"+ "Final Grade: " + average + "\n" + "Absences: " + abstention)
            }

        }
    }
}