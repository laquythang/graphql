package com.example.demomvvmgraphql.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.viewmodel.SplashScreenViewModel
import javax.inject.Inject

@SuppressLint("Registered")
@Suppress("DEPRECATION")
class SpashActivity : BaseDaggerActivity() {

    private lateinit var splashScreenViewModel: SplashScreenViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_spash_screen)
        splashScreenViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SplashScreenViewModel::class.java)
        splashScreenViewModel.isFinished.observe(this, Observer {
            startActivity(Intent(this@SpashActivity, MainActivity::class.java))
            finish()
        })
    }
}
