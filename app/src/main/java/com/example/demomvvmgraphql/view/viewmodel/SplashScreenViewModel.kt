package com.example.demomvvmgraphql.view.viewmodel


import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvmgraphql.view.util.SPLASH_SCREEN_DELAY
import javax.inject.Inject


class SplashScreenViewModel @Inject constructor() : ViewModel() {

    val isFinished = MutableLiveData<Boolean>()

    init {
        object : CountDownTimer(SPLASH_SCREEN_DELAY, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                isFinished.postValue(true)
            }

        }.start()
    }
}