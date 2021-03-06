package com.example.demomvvmgraphql.network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.PokemonRepositoryQuery
import io.reactivex.Observable
import javax.inject.Inject

class ApiService @Inject constructor(private var apolloClient: ApolloClient) {

    fun getPokemons(count: Int): Observable<List<PokemonRepositoryQuery.Pokemon>> {
        return Rx2Apollo.from(apolloClient.query(PokemonRepositoryQuery.builder().first(count).build()))
            .map {
                it.data()?.pokemons()
            }
    }

    fun getPokemonDetail(id: String): Observable<PokemonDetailRepositoryQuery.Pokemon> {
        return Rx2Apollo.from(apolloClient.query(PokemonDetailRepositoryQuery.builder().id(id).build()))
            .map {
                it.data()?.pokemon()
            }
    }

}