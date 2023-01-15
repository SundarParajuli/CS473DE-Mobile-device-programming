package com.sundar.jetpackquiz.ui.splash.state

sealed class SplashUIState {
    object Empty : SplashUIState()
    object OnBoardingDone : SplashUIState()
}