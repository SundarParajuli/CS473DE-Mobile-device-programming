package com.sundar.jetpackquiz.di

import com.sundar.jetpackquiz.data.repository.QuizRepositoryImpl
import com.sundar.jetpackquiz.data.repository.UserRepositoryImpl
import com.sundar.jetpackquiz.domain.repository.QuizRepository
import com.sundar.jetpackquiz.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindQuizRepository(quizRepositoryImpl: QuizRepositoryImpl): QuizRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}