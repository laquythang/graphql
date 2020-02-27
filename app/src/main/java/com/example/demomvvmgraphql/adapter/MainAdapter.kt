package com.example.demomvvmgraphql.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.demomvvmgraphql.PokemonRepositoryQuery
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.binding.IDataBindingComponent
import com.example.demomvvmgraphql.databinding.MainAdapterSingleRowBinding

class MainAdapter constructor(private val dataBindingComponent: IDataBindingComponent, var list: List<PokemonRepositoryQuery.Pokemon>?, var click: (PokemonRepositoryQuery.Pokemon) -> Unit) : DataBoundListAdapter<PokemonRepositoryQuery.Pokemon>(

        diffCallback = object : DiffUtil.ItemCallback<PokemonRepositoryQuery.Pokemon>() {
            override fun areItemsTheSame(oldItem: PokemonRepositoryQuery.Pokemon, newItem: PokemonRepositoryQuery.Pokemon): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PokemonRepositoryQuery.Pokemon, newItem: PokemonRepositoryQuery.Pokemon): Boolean {
                return oldItem == newItem
            }
        }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.main_adapter_single_row, parent, false, dataBindingComponent.getDataBindingComponent())
    }

    override fun bind(binding: ViewDataBinding, item: PokemonRepositoryQuery.Pokemon) {
        when (binding) {
            is MainAdapterSingleRowBinding -> {
                binding.pokemomdetail = item
                binding.root.setOnClickListener {
                    click.invoke(item)
                }
            }
        }
    }
}


//(var list: List<PokemonRepositoryQuery.Pokemon>, var click: (PokemonRepositoryQuery.Pokemon) -> Unit) :
//    RecyclerView.Adapter<MainAdapter.SingleRow>() {
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
//        p0.bind(p1)
//    }
//
//    inner class SingleRow(var view: View) : RecyclerView.ViewHolder(view) {
//
//        fun bind(pos: Int) {
//            Glide.with(view.context).load(list[pos].image()).into(view.image)
//            view.name.text = list[pos].name()
//            PushDownAnim.setPushDownAnimTo(view.pokemonItem).setScale(PushDownAnim.MODE_STATIC_DP, 5F)
//                .setOnClickListener {
//                    click.invoke(list[pos])
//                }
//        }
//
//    }
//}