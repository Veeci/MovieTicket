package com.example.movieticketapp

import com.example.movieticketapp.domain.di.NavigationModule
import com.example.movieticketapp.domain.di.ServiceModule
import com.example.movieticketapp.domain.di.ViewModelModule
import com.koai.base.BaseApplication
import org.koin.dsl.module

class MainApplication : BaseApplication() {
    override fun appModule() =
        module {
            includes(
                super.appModule(),
                NavigationModule.init(),
                ViewModelModule.init(),
                ServiceModule.init(),
            )
        }
}
