package com.sundar.jetpackquiz.domain.repository

interface UserRepository {
    fun isOnBoardingDone(): Boolean
    fun saveOnBoardingDone(value: Boolean)
}