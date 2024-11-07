package com.example.movieticketapp.presentation.auth.login

import android.os.Bundle
import com.koai.base.main.action.router.BaseRouter

interface LoginRouter : BaseRouter {
    fun goToMainScreen(extras: Bundle? = null)

    fun goToForgotPassScreen()

    fun goToSignupScreen()
}
