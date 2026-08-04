package com.example.affirmations

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import kotlin.getValue

class VMActivity : AppCompatActivity() {
    private val viewModel: VmViewModel by viewModels()

    lateinit var countTextView: TextView

    var secsObserverphno: Observer<Int> = object : Observer<Int> {
        override fun onChanged(seconds: Int) {
            //receiving the updates/notification
            countTextView.setText(seconds.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmactivity)
        Log.i("VmActivitiy"," activvity created")

        countTextView = findViewById<TextView>(R.id.tvCount)
        countTextView.setText(""+viewModel.count)
        viewModel._seconds.observe(this, secsObserverphno);

    }

    fun handleButtonClick(view: View) {
        viewModel.startTimer()
        countTextView.setText(""+viewModel._seconds)
       // viewModel.incrementCount()
       // countTextView.setText(""+viewModel.count)
    }

    override fun onStop() {
        super.onStop()
        Log.i("VmActivitiy","stopped activvity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("VmActivitiy"," activvity destroyed")

    }
}