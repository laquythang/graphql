package com.example.demomvvmgraphql.binding.interfacebinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery

interface ViewBindingAdapters {
    @BindingAdapter(value = ["view"], requireAll = false)
    fun bindView(view : View, evolutions: List<PokemonDetailRepositoryQuery.Evolution>?);
}