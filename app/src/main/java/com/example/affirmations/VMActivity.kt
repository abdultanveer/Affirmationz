package com.example.affirmations

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.getValue

class VMActivity : AppCompatActivity() {
    private val viewModel: VmViewModel by viewModels()

    lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmactivity)
        countTextView = findViewById<TextView>(R.id.tvCount)
        countTextView.setText(""+viewModel.count)

    }

    fun handleButtonClick(view: View) {
        viewModel.incrementCount()
        countTextView.setText(""+viewModel.count)
    }
}