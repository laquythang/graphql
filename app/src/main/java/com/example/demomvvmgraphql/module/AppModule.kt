package com.example.demomvvmgraphql.module

import com.example.demomvvmgraphql.activity.MainActivity
import com.example.demomvvmgraphql.activity.SpashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SpashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}