package com.example.demomvvmgraphql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demomvvmgraphql.PokemonRepositoryQuery
import com.example.demomvvmgraphql.R
import com.thekhaeng.pushdownanim.PushDownAnim
import kotlinx.android.synthetic.main.main_adapter_single_row.view.*

class MainAdapter(var list: List<PokemonRepositoryQuery.Pokemon>) :
    RecyclerView.Adapter<MainAdapter.SingleRow>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SingleRow {
        return SingleRow(
            LayoutInflater.from(p0.context).inflate(
                R.layout.main_adapter_single_row,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: SingleRow, p1: Int) {
        p0.bind(p1)
    }


    inner class SingleRow(var view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(pos: Int) {
            Glide.with(view.context).load(list[pos].image()).into(view.image)
            view.name.text = list[pos].name()
            PushDownAnim.setPushDownAnimTo(view.pokemonItem)
                .setScale(PushDownAnim.MODE_STATIC_DP, 5F)
                .setOnClickListener {
                    //                    click.invoke(list[pos])
                }
        }

    }
}