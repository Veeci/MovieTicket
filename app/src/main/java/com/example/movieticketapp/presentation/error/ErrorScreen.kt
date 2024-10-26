package com.example.movieticketapp.presentation.error

import android.os.Bundle
import android.view.Gravity
import com.example.movieticketapp.MainNavigator
import com.example.movieticketapp.R
import com.example.movieticketapp.databinding.LayoutErrorScreenBinding
import com.koai.base.main.action.router.BaseRouter
import com.koai.base.main.extension.navigatorViewModel
import com.koai.base.main.screens.BaseDialog

class ErrorScreen :
    BaseDialog<LayoutErrorScreenBinding, BaseRouter, MainNavigator>(layoutId = R.layout.layout_error_screen) {
    override val navigator: MainNavigator by navigatorViewModel()
    override var gravity: Int = Gravity.TOP
    override var canceledOnTouchOutside = true

    override fun initView(
        savedInstanceState: Bundle?,
        binding: LayoutErrorScreenBinding,
    ) {
        binding.error = arguments?.getString("error_message")
        binding.root.postDelayed({
            router?.onPopScreen()
        }, 3000)
    }
}
