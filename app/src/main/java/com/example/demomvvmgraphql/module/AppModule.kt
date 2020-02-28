package com.example.demomvvmgraphql.module

import com.example.demomvvmgraphql.view.activity.MainActivity
import com.example.demomvvmgraphql.view.activity.SpashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SpashActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun bindMainActivity(): MainActivity

}