package com.example.movieticketapp.data.service

import com.example.movieticketapp.data.ApiService
import com.example.movieticketapp.data.BaseApiService
import com.example.movieticketapp.domain.utils.Constants

object ApiClient : BaseApiService<ApiService>() {
    override fun getApiService() = ApiService::class.java

    override fun getBaseUrl() = Constants.BASE_URL
}
