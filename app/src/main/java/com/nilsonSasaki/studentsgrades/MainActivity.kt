package com.nilsonSasaki.studentsgrades

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalculate: Button = findViewById(R.id.btCalculate)
        btCalculate.setOnClickListener { calculate() }

    }

    private fun calculate() {
        val etExam1: EditText = findViewById(R.id.etExam1)
        val etExam2: EditText = findViewById(R.id.etExam2)
        val etAbsence: EditText = findViewById(R.id.etAbsences)
        val tvResults: TextView = findViewById(R.id.tvResults)

        val exam1 = etExam1.text.toString().toDouble()
        val exam2 = etExam2.text.toString().toDouble()
        val absences = etAbsence.text.toString().toInt()

        val average = String.format("%.2f", (exam1 + exam2) / 2)

        if (average.toDouble() >= 6 && absences <= 10) {
            tvResults.text = getString(R.string.result_text, "approved", average, absences)
            tvResults.setTextColor(Color.GREEN)
        } else {
            tvResults.text = getString(R.string.result_text, "reproved", average, absences)
            tvResults.setTextColor(Color.RED)
        }
        hideKeyboard()


    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}