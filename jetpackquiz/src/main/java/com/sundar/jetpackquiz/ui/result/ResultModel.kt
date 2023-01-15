package com.sundar.jetpackquiz.ui.result

import com.sundar.jetpackquiz.domain.model.Quiz

data class ResultModel(
    val quiz: Quiz,
    val yourAnswer: String,
    val correctAnswer: String
)