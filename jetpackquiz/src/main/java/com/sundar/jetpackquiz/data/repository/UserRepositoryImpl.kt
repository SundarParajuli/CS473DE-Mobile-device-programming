package com.sundar.jetpackquiz.data.repository

import com.sundar.jetpackquiz.data.local.PreferenceManager
import com.sundar.jetpackquiz.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
) : UserRepository {
    override fun isOnBoardingDone(): Boolean {
        return preferenceManager.getBoolean(PreferenceManager.KEY_ON_BOARDING_DONE)
    }

    override fun saveOnBoardingDone(value: Boolean) {
        preferenceManager.saveBoolean(PreferenceManager.KEY_ON_BOARDING_DONE, value)
    }
}