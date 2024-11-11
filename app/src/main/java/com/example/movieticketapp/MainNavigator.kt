package com.example.movieticketapp

import android.os.Bundle
import com.example.movieticketapp.domain.utils.Constants
import com.example.movieticketapp.presentation.auth.login.LoginRouter
import com.example.movieticketapp.presentation.auth.signup.SignUpRouter
import com.example.movieticketapp.presentation.auth.splash.SplashRouter
import com.koai.base.main.action.navigator.BaseNavigator

class MainNavigator :
    BaseNavigator(),
    MainActivityRouter,
    SplashRouter,
    LoginRouter,
    SignUpRouter {
    override fun gotoErrorScreen(message: String) {
        offNavScreen(
            R.id.action_global_errorScreen,
            extras =
                Bundle().apply {
                    putString(Constants.MESSAGE_ERROR, message)
                },
        )
    }

    override fun goToLoginFromSplash() {
        offNavScreen(R.id.action_global_loginScreen)
    }

    override fun goToMainScreen(extras: Bundle?) {
        offNavScreen(
            action = R.id.action_global_mainScreen,
            extras = extras ?: Bundle(),
            isFinished = true,
        )
    }

    override fun goToForgotPassScreen() {
        TODO("Not yet implemented")
    }

    override fun goToSignupScreen() {
        offNavScreen(R.id.action_global_signUpScreen)
    }

    override fun goToLoginScreen() {
        offNavScreen(R.id.action_global_loginScreen)
    }
}
