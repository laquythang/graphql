package com.example.demomvvmgraphql.binding

import android.os.Build
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.binding.interfacebinding.ImageViewBindingAdapters
import com.example.demomvvmgraphql.binding.interfacebinding.TextViewBindingAdapters
import com.example.demomvvmgraphql.binding.interfacebinding.ViewBindingAdapters

@Suppress("DEPRECATION")
class BindingAdaptersImplement : ImageViewBindingAdapters, TextViewBindingAdapters,ViewBindingAdapters {
    override fun bindText(textView: AppCompatTextView, text: String?) {
        textView.text= text
    }

    override fun bindWeight(textView: AppCompatTextView, weight: PokemonDetailRepositoryQuery.Weight?) {
        val html = textView.context.getString(R.string.textWeight, weight?.maximum(), weight?.minimum())
        textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(html).toString()
        }
    }

    override fun bindWeight(textView: AppCompatTextView, height: PokemonDetailRepositoryQuery.Height?) {
        val html = textView.context.getString(R.string.textWeight, height?.maximum(), height?.minimum())
        textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(html).toString()
        }
    }

    override fun bindResistance(textView: AppCompatTextView, resistance: List<String?>?) {
        var resistanceString = ""
        if (resistance != null) {
            for (item in resistance) {
                resistanceString += "$item,"
            }
        }
        textView.text = resistanceString
    }

    override fun bindSpecial(textView: AppCompatTextView, specialAttacks: List<PokemonDetailRepositoryQuery.Special>?) {
        var specialAttacksString = ""
        if (specialAttacks != null)
            for (item in specialAttacks) {
                specialAttacksString += "${item.name()},"
            }
        textView.text = specialAttacksString
    }

    override fun bindWeaknesses(textView: AppCompatTextView, weaknesses: List<String?>?) {
        var weaknessesString = ""
        if (weaknesses != null) {
            for (item in weaknesses) {
                weaknessesString += "$item,"
            }
        }
        textView.text = weaknessesString
    }

    override fun bindImage(imageView: ImageView, imageUrl: String?) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(imageView.context).load(imageUrl).centerCrop().into(imageView)
        }
    }

    override fun bindView(view: View, evolutions: List<PokemonDetailRepositoryQuery.Evolution>?) {
        if (evolutions==null||evolutions.isEmpty()){
            view.visibility= View.GONE
        }else{
            view.visibility= View.VISIBLE

        }
    }

}