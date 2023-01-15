package com.sundar.jetpackquiz.domain.repository

import com.sundar.jetpackquiz.domain.model.Quiz

interface QuizRepository {
    suspend fun getQuizById(id: Int): Quiz?
    suspend fun getQuizList(): List<Quiz>
    suspend fun saveQuiz(quiz: Quiz)
}