package com.example.demomvvmgraphql.module

import com.example.demomvvmgraphql.view.fragment.PokemonDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributePokemonDetailFragment(): PokemonDetailFragment
}
