package com.example.affirmations

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VMActivity : AppCompatActivity() {
    var count = 0
    lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmactivity)
        countTextView = findViewById<TextView>(R.id.tvCount)
        countTextView.setText(""+count)

    }

    fun handleButtonClick(view: View) {
        count++
        countTextView.setText(""+count)
    }
}