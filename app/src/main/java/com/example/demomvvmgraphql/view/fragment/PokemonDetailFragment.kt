package com.example.demomvvmgraphql.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.adapter.PokemonEvulotionAdapter
import com.example.demomvvmgraphql.base.Resource
import com.example.demomvvmgraphql.databinding.FragmentPokemonDetailBinding
import com.example.demomvvmgraphql.viewmodel.PokemonDetailViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

@Suppress("DEPRECATION")
class PokemonDetailFragment : DataBindingDaggerFragment(), IFragment {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel

    private var pokemondetail: PokemonDetailRepositoryQuery.Pokemon? = null
    lateinit var binding: FragmentPokemonDetailBinding

    private lateinit var adapter: PokemonEvulotionAdapter
    private var pokemonID: String? = null

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_detail, container, false, dataBinding.getDataBindingComponent())
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState == null) {
            pokemonID = arguments?.getString(POKEMON_ID)!!
        } else {
            pokemonID = savedInstanceState.getString(POKEMON_ID, "")
        }
        Log.e("Tag", "--- " + pokemonID)
        pokemonDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(PokemonDetailViewModel::class.java)
        val liveData = pokemonID?.let { pokemonDetailViewModel.getPokemonDetail(it) }
        binding.data = liveData
        liveData?.observe(viewLifecycleOwner, Observer {
            if (it is Resource.Success) {
                pokemondetail = it.data
                binding.pokemon = pokemondetail
                binding.evolutionRecycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                        this@PokemonDetailFragment.context,
                        androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
                it.data?.evolutions().let { item ->
                    val list = item
                    adapter = PokemonEvulotionAdapter(dataBindingComponent = dataBinding, list = list) { pokemon ->
                        newInstance(pokemon.id()).let { it3 ->
                            activity?.supportFragmentManager?.beginTransaction()?.setCustomAnimations(
                                    android.R.anim.fade_in,
                                    android.R.anim.fade_out,
                                    android.R.anim.fade_in,
                                    android.R.anim.fade_out)?.replace(R.id.mainActivityRoot, it3)?.addToBackStack(PokemonDetailFragment::class.java.name)?.commit()
                        }
                    }
                    binding.evolutionRecycler.adapter = adapter
                    adapter.submitList(list)
                }
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(POKEMON_ID, pokemonID)
    }

    override fun getFragment(): Fragment {
        return this
    }

}