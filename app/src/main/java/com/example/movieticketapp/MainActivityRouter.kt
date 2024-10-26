package com.example.movieticketapp

import com.koai.base.main.action.router.BaseRouter

interface MainActivityRouter : BaseRouter {
    fun gotoErrorScreen(message: String = "Unknown Error!")
}
