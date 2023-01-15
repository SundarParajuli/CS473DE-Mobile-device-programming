package com.sundar.jetpackquiz.data.mapper

import com.sundar.jetpackquiz.data.local.entity.QuizEntity
import com.sundar.jetpackquiz.domain.model.Quiz

fun QuizEntity.toQuiz(): Quiz {
    return Quiz(
        id = id,
        question = question,
        answer = answer,
        options = options
    )
}

fun Quiz.toEntity() = QuizEntity(
    id = id,
    question = question,
    answer = answer,
    options = options
)