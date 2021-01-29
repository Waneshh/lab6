package com.example.laba2_students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var seconds = 0
    private var isRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
        }
        runTimer()
    }

    override fun onStart() {
        super.onStart()
        isRunning = true
    }

    override fun onStop() {
        super.onStop()
        isRunning = false
    }

    fun onBtnClick(view: View) {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val groupNumber = spinner.selectedItem as String

        val intent = Intent(this, StudentListActivity::class.java)
        intent.putExtra(StudentListActivity.groupNumber, groupNumber)
        startActivity(intent)
    }

    private fun runTimer() {
        val timeView = findViewById<TextView>(R.id.textView)
        Handler(Looper.getMainLooper()).apply {
             val runnable = object: Runnable {
                 override fun run() {
                     val hours = seconds / 3600
                     val minutes = (seconds % 3600) / 60
                     val secs = seconds % 60

                     val time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)
                     timeView.text = time
                     seconds += 1

                     if(isRunning) {
                         seconds++
                     }
                     postDelayed(this, 1000)
                 }
             }
            runnable.run()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
    }

    fun onGrpBtnClick(view: View) {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val groupNumber = spinner.selectedItem as String

        val intent = Intent(this, StudentsGroupActivity::class.java)
        intent.putExtra(StudentsGroupActivity.groupNumber, groupNumber)
        startActivity(intent)
    }

}