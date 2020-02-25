package com.example.demomvvmgraphql.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demomvvmgraphql.PokemonDetailRepositoryQuery
import com.example.demomvvmgraphql.base.Resource
import com.example.demomvvmgraphql.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailRepository @Inject constructor(private var apiService: ApiService) : Repository {

    private val compositeDisposable = CompositeDisposable()

    private val result = MutableLiveData<Resource<PokemonDetailRepositoryQuery.Pokemon>>()

    fun getPokemonDetail(id: String): LiveData<Resource<PokemonDetailRepositoryQuery.Pokemon>> {
        addDisposable(
            apiService.getPokemonDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { whenStart() }
                .subscribe(
                    { result -> whenSuccess(result) },
                    { cause -> whenError(cause.toString()) }
                )
        )

        return result
    }

    private fun whenStart() {
        result.value = Resource.Loading()
    }

    fun whenSuccess(pokemon: PokemonDetailRepositoryQuery.Pokemon) {
        result.value = Resource.Success(pokemon)
    }

    fun whenError(cause: String) {
        result.value = Resource.Failure(cause)
    }

    override fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}