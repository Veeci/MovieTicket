package com.example.movieticketapp.presentation.auth.login

import android.os.Bundle
import com.example.movieticketapp.MainNavigator
import com.example.movieticketapp.R
import com.example.movieticketapp.databinding.FragmentLoginScreenBinding
import com.koai.base.main.extension.navigatorViewModel
import com.koai.base.main.screens.BaseScreen

class LoginScreen : BaseScreen<FragmentLoginScreenBinding, LoginRouter, MainNavigator>(R.layout.fragment_login_screen) {
    override val navigator: MainNavigator by navigatorViewModel()

    override fun initView(
        savedInstanceState: Bundle?,
        binding: FragmentLoginScreenBinding,
    ) {
        TODO("Not yet implemented")
    }
}
