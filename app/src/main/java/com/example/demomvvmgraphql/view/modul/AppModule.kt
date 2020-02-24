package com.example.demomvvmgraphql.view.modul

import com.example.demomvvmgraphql.view.activity.MainActivity
import com.example.demomvvmgraphql.view.activity.SpashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SpashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}