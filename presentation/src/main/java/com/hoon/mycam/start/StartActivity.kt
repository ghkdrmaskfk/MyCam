package com.hoon.mycam.start

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator

import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.hoon.mycam.R
import com.hoon.mycam.databinding.ActivityMainBinding
import com.hoon.mycam.databinding.ActivityStartBinding
import com.hoon.mycam.main.MainActivity


class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private val viewModel: StartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        startSplash(installSplashScreen())
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activity = this
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.apply {

        }
    }

    private fun startSplash(screen: SplashScreen) {
        screen.setOnExitAnimationListener { splashScreenView ->
            val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 2f, 1.5f)
            val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 2f, 1.5f)

            ObjectAnimator.ofPropertyValuesHolder(splashScreenView.iconView, scaleX, scaleY).run {
                interpolator = AnticipateInterpolator()
                duration = 2000L
                doOnEnd {
                    splashScreenView.remove()
                    startNextActivity()
                }
                start()
            }
        }
    }

    private fun startNextActivity() {
        startActivity(MainActivity.getIntent(this))
        finish()
    }
}