package com.example.movieticketapp.data

import com.example.movieticketapp.data.service.MoviesService
import com.koai.base.network.BaseApiService

interface ApiService :
    BaseApiService,
    MoviesService
