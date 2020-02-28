package com.example.demomvvmgraphql.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.base.Resource
import com.example.demomvvmgraphql.repository.PokemonDetailRepository
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(private val pokemonDetailRepository: PokemonDetailRepository) : ViewModel() {

    fun getPokemonDetail(id: String): LiveData<Resource<PokemonDetailRepositoryQuery.Pokemon>> {
        return pokemonDetailRepository.getPokemonDetail(id)
    }

}