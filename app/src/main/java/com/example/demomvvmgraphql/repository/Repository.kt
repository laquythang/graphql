package com.example.demomvvmgraphql.repository

import io.reactivex.disposables.Disposable

interface Repository {

    fun addDisposable(disposable: Disposable)

    fun clear()

}