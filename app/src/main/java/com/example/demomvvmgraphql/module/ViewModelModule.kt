package com.example.demomvvmgraphql.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demomvvmgraphql.binding.BindingAdaptersImplement
import com.example.demomvvmgraphql.binding.DataBindingComponentImplement
import com.example.demomvvmgraphql.binding.IDataBindingComponent
import com.example.demomvvmgraphql.viewmodel.*
import com.example.demomvvmgraphql.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindDataBindingComponent(dataBindingComponent: DataBindingComponentImplement): IDataBindingComponent

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    internal abstract fun bindSplashViewModel(splashScreenViewModel: SplashScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailViewModel::class)
    internal abstract fun bindPokemonDetailViewModel(pokemonDetailViewModel: PokemonDetailViewModel): ViewModel

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideBindingAdapter(): BindingAdaptersImplement {
            return BindingAdaptersImplement()
        }
    }
}