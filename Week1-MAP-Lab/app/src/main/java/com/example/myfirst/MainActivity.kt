package com.example.myfirst

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()

            val studentNumber = findViewById<TextInputEditText>(R.id.student_number_input)
                ?.text.toString().trim()

            if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
                return@setOnClickListener
            }

            if (studentNumber.length != 11) {
                Toast.makeText(this, getString(R.string.student_number_error), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
                return@setOnClickListener
            }

            // Kalau valid, tampilkan
            nameDisplay.text = "${getString(R.string.name_greet)} $nameInput\nStudent No: $studentNumber"
        }
    }
}
