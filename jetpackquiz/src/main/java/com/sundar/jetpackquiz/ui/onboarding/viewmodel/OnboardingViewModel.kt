package com.sundar.jetpackquiz.ui.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import com.sundar.jetpackquiz.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun saveOnboardingDone(value:Boolean) = userRepository.saveOnBoardingDone(value)

}