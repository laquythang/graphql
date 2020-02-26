package com.example.demomvvmgraphql.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.adapter.PokemonEvulotionAdapter
import com.example.demomvvmgraphql.base.Resource
import com.example.demomvvmgraphql.databinding.PokemonDetailBinding
import com.example.demomvvmgraphql.viewmodel.PokemonDetailViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.pokemon_detail.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class PokemonDetailFragment : DataBindingDaggerFragment(), IFragment {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel

    lateinit var binding: PokemonDetailBinding

    private lateinit var adapter: PokemonEvulotionAdapter

    companion object {
        private const val POKEMON_ID = "POKEMON_ID"

        fun newInstance(pokemonId: String) = PokemonDetailFragment().apply {
            arguments = Bundle(1).apply {
                putString(POKEMON_ID, pokemonId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.pokemon_detail,
            container,
            false,
            dataBinding.getDataBindingComponent()
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pokemonDetailViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(PokemonDetailViewModel::class.java)
        val liveData = arguments?.getString(POKEMON_ID)?.let { pokemonDetailViewModel.getPokemonDetail(it) }
        binding.data = liveData
        liveData?.observe(viewLifecycleOwner, Observer {
            if (it is Resource.Success) {
                binding.pokemon = it.data
                binding.evolutionRecycler.adapter =  it.data?.evolutions()?.let { it1 ->
                    PokemonEvulotionAdapter(it1) { pokemon ->
                        newInstance(pokemon.id()).let { it3 ->
                            activity?.supportFragmentManager?.beginTransaction()
                                    ?.setCustomAnimations(
                                            android.R.anim.fade_in,
                                            android.R.anim.fade_out,
                                            android.R.anim.fade_in,
                                            android.R.anim.fade_out
                                    )?.add(
                                            R.id.mainActivityRoot,
                                            it3
                                    )?.addToBackStack(PokemonDetailFragment::class.java.name)
                                    ?.commit()
                        }
                    }
                }
            }
        })
    }

    override fun getFragment(): Fragment {
        return this
    }

}