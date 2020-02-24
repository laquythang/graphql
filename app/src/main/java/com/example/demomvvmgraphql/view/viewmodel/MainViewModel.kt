package com.example.demomvvmgraphql.view.viewmodel

import PokemonRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvmgraphql.PokemonRepositoryQuery
import com.example.demomvvmgraphql.view.base.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    @Inject
    lateinit var pokemonLiveData: LiveData<Resource<List<PokemonRepositoryQuery.Pokemon>>>

    init {
        getPokemons()
    }

    private fun getPokemons() {
        pokemonLiveData = pokemonRepository.getPokemons(200)
    }

    override fun onCleared() {
        pokemonRepository.clear()
        super.onCleared()
    }

}