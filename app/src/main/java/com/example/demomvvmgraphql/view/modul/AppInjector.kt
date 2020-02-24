package com.example.demomvvmgraphql.view.modul

import com.example.demomvvmgraphql.view.App

object AppInjector {
    fun init(app: App) {
        DaggerAppComponent.builder().application(app)
            .build().inject(app)
    }
}
