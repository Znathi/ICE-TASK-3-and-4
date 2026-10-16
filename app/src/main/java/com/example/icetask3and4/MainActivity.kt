package com.example.icetask3and4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            val etName = findViewById<EditText>(R.id.etName)
            val etCourse = findViewById<EditText>(R.id.etCourse)
            val btnDisplay = findViewById<Button>(R.id.btnDisplay)
            val tvResult = findViewById<TextView>(R.id.tvResult)


            btnDisplay.setOnClickListener {


                val name = etName.text.toString().trim()
                val course = etCourse.text.toString().trim()


                if (name.isBlank() || course.isBlank()) {

                    tvResult.text =
                        "Please enter both your name and course."

                } else {


                    val profileDetails = arrayOf(
                        "Name: $name",
                        "Course: $course"
                    )


                    var result = "Profile saved successfully!\n\n"

                    for (detail in profileDetails) {
                        result += "$detail\n"
                    }


                    tvResult.text = result
                }
            }
        }
    }