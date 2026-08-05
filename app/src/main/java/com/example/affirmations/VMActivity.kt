package com.example.affirmations

import android.content.Intent
import android.net.Uri
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

    fun handleDial(view: View) {
        //explicit intent == passing the name of the class
        var dialIntent = Intent(this, MainActivity::class.java)
         //implicit intent -- commponent to be invoked is determined by action string or the data
        //Intent(Intent.ACTION_VIEW,Uri.parse("https://www.yahoo.com"))
            //Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))

        startActivity(dialIntent)
    }
}