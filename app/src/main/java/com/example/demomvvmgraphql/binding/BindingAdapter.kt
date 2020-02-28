package com.example.demomvvmgraphql.binding

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

//    @JvmStatic
//    @BindingAdapter("weight")
//    fun bindWeight(textView: AppCompatTextView, weight: String?){
//        textView.text = weight
//    }

}