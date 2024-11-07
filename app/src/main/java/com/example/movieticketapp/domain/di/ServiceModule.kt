package com.example.movieticketapp.domain.di

import com.example.movieticketapp.data.ApiService
import com.example.movieticketapp.data.service.ApiClient
import com.example.movieticketapp.domain.utils.Constants
import org.koin.dsl.module

object ServiceModule {
    fun init() =
        module {
            factory<ApiService?> {
                ApiClient.getService(
                    get(),
                    allowVpn = true,
                    accessToken = Constants.ACCESS_TOKEN,
                )
            }
        }
}
