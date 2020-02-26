package com.example.demomvvmgraphql.binding.interfacebinding

import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery

interface TextViewBindingAdapters {
//    @BindingAdapter(value = ["timeStamp"], requireAll = false)
//    fun bindTime(textView: TextView, timeStamp: Long?)
//
//    @BindingAdapter(value = ["roomsHighlightCount"], requireAll = false)
//    fun bindRoomsHighlightCount(textView: TextView, rooms: List<Room>?)
//
//    @BindingAdapter(value = ["decryptMessage"], requireAll = false)
//    fun bindDecryptMessage(textView: TextView, message: Message?)
//
//    @BindingAdapter(value = ["formatName"], requireAll = false)
//    fun bindFormatName(textView: TextView, room: Room?)
//
//    @BindingAdapter(value = ["checkMissCall"], requireAll = false)
//    fun bindCheckMissCall(textView: TextView, message: Message?)
//
//    @BindingAdapter(value = ["dataSize"], requireAll = false)
//    fun bindDataSize(textView: TextView, fileContent: ImageMessage?)

    @BindingAdapter(value = ["text"], requireAll = false)
    fun bindText(textView: AppCompatTextView, text:String?)

    @BindingAdapter(value = ["weight"], requireAll = false)
    fun bindWeight(textView: AppCompatTextView, weight: PokemonDetailRepositoryQuery.Weight?)

    @BindingAdapter(value = ["height"], requireAll = false)
    fun bindWeight(textView: AppCompatTextView, height: PokemonDetailRepositoryQuery.Height?)

    @BindingAdapter(value = ["resistance"], requireAll = false)
    fun bindResistance(textView: AppCompatTextView, resistance: List<String?>?)

    @BindingAdapter(value = ["special"], requireAll = false)
    fun bindSpecial(textView: AppCompatTextView, specialAttacks: List<PokemonDetailRepositoryQuery.Special>?)

    @BindingAdapter(value = ["weaknesses"], requireAll = false)
    fun bindWeaknesses(textView: AppCompatTextView, weaknesses: List<String?>?)

}