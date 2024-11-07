package com.example.movieticketapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.movieticketapp.databinding.ActivityMainBinding
import com.koai.base.main.BaseActivity
import com.koai.base.main.action.event.ErrorEvent
import com.koai.base.main.action.event.NavigationEvent
import com.koai.base.utils.LogUtils
import com.koai.base.widgets.BaseLoadingView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityRouter, MainNavigator>(
    R.layout.activity_main,
) {
    override val navigator: MainNavigator by viewModel()

    override fun initView(
        savedInstanceState: Bundle?,
        binding: ActivityMainBinding,
    ) {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
            statusBarHeight = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            try {
                val layoutParamsPointTop = binding.pointTop.layoutParams as ViewGroup.MarginLayoutParams
                layoutParamsPointTop.topMargin = statusBarHeight
                binding.pointTop.layoutParams = layoutParamsPointTop
            } catch (e: Exception) {
                LogUtils.log("Error in Margin", e.message ?: "Unknown Error")
            }
            ViewCompat.onApplyWindowInsets(view, windowInsets)
        }
    }

    override fun onNavigationEvent(event: NavigationEvent) {
        when (event) {
            is ErrorEvent -> event.message?.let { msg -> router?.gotoErrorScreen(msg) }
            else -> {
                super.onNavigationEvent(event)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getLoadingView(): View {
        return super.getLoadingView().apply {
            (this as BaseLoadingView).setLogo(
                resources.getDrawable(
                    R.drawable.ic_logo,
                    null,
                ),
            )
        }
    }
}
