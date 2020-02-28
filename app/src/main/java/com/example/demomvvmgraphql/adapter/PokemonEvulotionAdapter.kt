package com.example.demomvvmgraphql.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.PokemonRepositoryQuery
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.binding.IDataBindingComponent
import com.example.demomvvmgraphql.databinding.AdapterEvulotionBinding
import com.example.demomvvmgraphql.databinding.MainAdapterSingleRowBinding

class PokemonEvulotionAdapter constructor(private val dataBindingComponent: IDataBindingComponent, var list: List<PokemonDetailRepositoryQuery.Evolution>?, var click: (PokemonDetailRepositoryQuery.Evolution) -> Unit
) : DataBoundListAdapter<PokemonDetailRepositoryQuery.Evolution>(
        diffCallback = object : DiffUtil.ItemCallback<PokemonDetailRepositoryQuery.Evolution>() {
            override fun areItemsTheSame(oldItem: PokemonDetailRepositoryQuery.Evolution, newItem: PokemonDetailRepositoryQuery.Evolution): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PokemonDetailRepositoryQuery.Evolution, newItem: PokemonDetailRepositoryQuery.Evolution): Boolean {
                return oldItem == newItem
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_evulotion,
                parent,
                false,dataBindingComponent.getDataBindingComponent()
        )
    }

    override fun bind(binding: ViewDataBinding, item: PokemonDetailRepositoryQuery.Evolution) {
        when (binding) {
            is AdapterEvulotionBinding -> {
                binding.evolution = item
                binding.root.setOnClickListener {
                    click.invoke(item)
                }
            }
        }
    }
//    private lateinit var binding : MainAdapterSingleRowBinding
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SingleRow {
//        return SingleRow(LayoutInflater.from(p0.context).inflate(R.layout.main_adapter_single_row, p0, false))
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(p0: SingleRow, p1: Int) {
//        p0.
//    }
//
//
//    inner class SingleRow(var view: View) : RecyclerView.ViewHolder(view) {
//
//
//    }
}