package com.example.demomvvmgraphql.view.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demomvvmgraphql.R
import com.example.demomvvmgraphql.databinding.ActivityMainBinding
import com.example.demomvvmgraphql.view.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("DEPRECATION")
class MainActivity : BaseDaggerActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mainViewModel: MainViewModel

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        val liveData = mainViewModel.pokemonLiveData
        binding.data = liveData
        binding.lifecycleOwner = this

        recycler.layoutManager = GridLayoutManager(this, 2)

        liveData.observe(this, Observer {
            //            if (it is Resource.Success) {
//                val adapter = it.data?.let { it1 ->
//                    MainAdapter(it1) { pokemon ->
//                        pokemon.id().let { it2 -> PokemonDetailFragment.newInstance(it2) }.let { it3 ->
//                            supportFragmentManager.beginTransaction().setCustomAnimations(
//                                android.R.anim.fade_in,
//                                android.R.anim.fade_out,
//                                android.R.anim.fade_in,
//                                android.R.anim.fade_out
//                            ).add(
//                                R.id.mainActivityRoot,
//                                it3
//                            ).addToBackStack(PokemonDetailFragment::class.java.name).commit()
//                        }
//                    }
//                }
//                recycler.adapter = adapter
//            }
        })
    }
}
