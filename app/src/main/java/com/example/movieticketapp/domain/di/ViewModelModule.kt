package com.example.movieticketapp.domain.di

import com.example.movieticketapp.domain.viewmodels.MovieViewModel
import com.koai.base.main.extension.screenViewModel
import org.koin.dsl.module

object ViewModelModule {
    fun init() =
        module {
            screenViewModel { MovieViewModel(get()) }
        }
}
