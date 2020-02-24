package com.example.demomvvmgraphql.view.repository

import io.reactivex.disposables.Disposable

interface Repository {

    fun addDisposable(disposable: Disposable)

    fun clear()

}