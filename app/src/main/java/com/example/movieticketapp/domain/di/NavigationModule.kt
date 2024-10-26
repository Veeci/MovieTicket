package com.example.movieticketapp.domain.di

import com.example.movieticketapp.MainNavigator
import com.koai.base.main.extension.navigatorViewModel
import org.koin.dsl.module

object NavigationModule {
    fun init() =
        module {
            navigatorViewModel { MainNavigator() }
        }
}
