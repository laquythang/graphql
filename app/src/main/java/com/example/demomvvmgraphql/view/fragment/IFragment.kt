package com.example.demomvvmgraphql.view.fragment

import androidx.fragment.app.Fragment

interface IFragment {
    fun getFragment(): Fragment

    companion object {
        const val POKEMOM_DETAIL_FRAGMENT = "POKEMOM_DETAIL_FRAGMENT";
    }
}