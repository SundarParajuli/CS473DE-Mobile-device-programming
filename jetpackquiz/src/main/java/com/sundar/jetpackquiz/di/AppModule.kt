package com.sundar.jetpackquiz.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sundar.jetpackquiz.data.local.AppDatabase
import com.sundar.jetpackquiz.data.local.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        val builder = Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
        builder.setQueryCallback(object : RoomDatabase.QueryCallback {
            override fun onQuery(sqlQuery: String, bindArgs: List<Any?>) {
                println("SQL Query: $sqlQuery SQL Args: $bindArgs")
            }
        }) {
            it.run()
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun providePreferenceManager(app: Application): PreferenceManager {
        return PreferenceManager(
            app.getSharedPreferences("mdp", Context.MODE_PRIVATE)
        )
    }

    @Provides
    @Singleton
    fun provideQuizDAO(appDatabase: AppDatabase) = appDatabase.quizDAO()
}