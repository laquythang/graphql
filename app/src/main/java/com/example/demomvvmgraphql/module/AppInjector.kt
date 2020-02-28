package com.example.demomvvmgraphql.module

import com.example.demomvvmgraphql.base.App

object AppInjector {

    fun init(app: App) {
        DaggerAppComponent.builder().application(app)
            .build().inject(app)
    }
}
