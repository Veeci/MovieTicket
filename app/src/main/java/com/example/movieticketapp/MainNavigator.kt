package com.example.movieticketapp

import android.os.Bundle
import com.example.movieticketapp.domain.utils.Constants
import com.koai.base.main.action.navigator.BaseNavigator

class MainNavigator :
    BaseNavigator(),
    MainActivityRouter {
    override fun gotoErrorScreen(message: String) {
        offNavScreen(
            R.id.action_global_errorScreen,
            extras =
                Bundle().apply {
                    putString(Constants.MESSAGE_ERROR, message)
                },
        )
    }
}
