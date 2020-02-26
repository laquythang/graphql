//package com.example.demomvvmgraphql.view.fragment
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.appcompat.app.AppCompatActivity
//import dagger.android.*
//import javax.inject.Inject
//
//@Suppress("DEPRECATION")
//@SuppressLint("Registered")
//abstract class BaseDaggerFragment : DaggerFragment() {
//
//    override fun onAttach(context: Context?) {
//        AndroidInjection.inject(this)
//        super.onAttach(context)
//    }
//}