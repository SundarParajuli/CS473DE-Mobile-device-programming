package com.sundar.jetpackquiz.data.repository
import com.sundar.jetpackquiz.data.local.dao.QuizDAO
import com.sundar.jetpackquiz.data.local.data.defaultQuizQuestions
import com.sundar.jetpackquiz.data.mapper.toEntity
import com.sundar.jetpackquiz.data.mapper.toQuiz
import com.sundar.jetpackquiz.domain.model.Quiz
import com.sundar.jetpackquiz.domain.repository.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val quizDAO: QuizDAO
) : QuizRepository {
    override suspend fun getQuizById(id: Int): Quiz? {
        return quizDAO.getQuizById(id)?.toQuiz()
    }

    override suspend fun getQuizList(): List<Quiz> {
        if(quizDAO.getQuizList().isEmpty()) {
            quizDAO.insert(defaultQuizQuestions())
        }
        return quizDAO.getQuizList().map { it.toQuiz() }
    }

    override suspend fun saveQuiz(quiz: Quiz) {
        quizDAO.insert(quiz.toEntity())
    }
}