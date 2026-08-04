package com.example.affirmations

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

//viewmodel = RAM = survivves the config
class VmViewModel: ViewModel() {
    var count = 0
    lateinit var timer: CountDownTimer


    fun startTimer():Unit {
        timer = object :CountDownTimer(10_000,1_000) {
            override fun onFinish() {
                Log.i("viewmodel","timer finished")
            }

            override fun onTick(timeLeft: Long) {
                count = timeLeft.toInt()
                Log.i("viewmodel","timeleft ="+timeLeft.toInt())
            }
        }.start()
    }



        fun incrementCount(){
        count++
    }

}