package com.example.movieticketapp.presentation.auth.splash

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.animation.doOnEnd
import com.example.movieticketapp.MainNavigator
import com.example.movieticketapp.R
import com.example.movieticketapp.databinding.FragmentSplashScreenBinding
import com.example.movieticketapp.domain.viewmodels.MovieViewModel
import com.koai.base.main.extension.navigatorViewModel
import com.koai.base.main.extension.screenViewModel
import com.koai.base.main.screens.BaseScreen

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseScreen<FragmentSplashScreenBinding, SplashRouter, MainNavigator>(R.layout.fragment_splash_screen) {
    override val navigator: MainNavigator by navigatorViewModel()
    private val movieViewModel: MovieViewModel by screenViewModel()

    override fun initView(
        savedInstanceState: Bundle?,
        binding: FragmentSplashScreenBinding,
    ) {
        observe()
        initialize()
    }

    private fun observe() {
        movieViewModel.popularList.observe(viewLifecycleOwner) { list ->
            val contentView = binding.root
            contentView.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (list.isNotEmpty()) {
                            contentView.viewTreeObserver.removeOnPreDrawListener(this)
                            animateExit()
                            true
                        } else {
                            false
                        }
                    }
                },
            )
        }
    }

    private fun initialize() {
        movieViewModel.getPopularList()
    }

    private fun animateExit() {
        val splashScreenView = binding.root

        val slideUp = ObjectAnimator.ofFloat(splashScreenView, View.TRANSLATION_Y, 0f, -splashScreenView.height.toFloat())
        slideUp.duration = 200L
        slideUp.startDelay = 1000L
        slideUp.interpolator = android.view.animation.AnticipateInterpolator()

        slideUp.doOnEnd {
            splashScreenView.visibility = View.GONE
            navigator.goToLoginScreen()
        }

        slideUp.start()
    }
}
