package com.sundar.jetpackquiz.data.local.data

import com.sundar.jetpackquiz.data.local.entity.QuizEntity

fun defaultQuizQuestions() = listOf(
    QuizEntity(
        id = 1,
        question = "What programming language is used for Android app development?",
        options = listOf("Java" ,"C#", "Scala", "C++"),
        answer = "a",
    ),
    QuizEntity(
        id = 2,
        question = "What is the name of the official Android app development framework?",
        options = listOf("Xamarin", "Android Studio", "react native", "Big data"),
        answer = "b",
    ),
    QuizEntity(
        id = 3,
        question = "What is the Android SDK",
        options = listOf("A set of tools for developing Android apps",
            "A virtual machine for Android app development",
            "A set of libraries for Android app development",
            "A set of guidelines for Android app design"),
        answer = "a",
    ),
    QuizEntity(
        id = 4,
        question = "What is the Android Manifest file?",
        options = listOf("A file that describes the basic information about the app",
            "A file containing json",
            "A file that describes the basic information about the app and the permissions required by the app and the components of the app",
            "A file that contains the app's user interface layout"),
        answer = "c",
    ),
    QuizEntity(
        id = 5,
        question = "What is an Activity in Android app development?",
        options = listOf(
            "A class that represents a screen or user interface in an Android app",
            "A class that represents a background service",
            "A class that represents a data model",
            "A class that represents a network connection"
        ),
        answer = "a",
    ),
    QuizEntity(
        id = 6,
        question = "APK stands for ______",
        options = listOf(
            "Android Package Kit",
            "Android Package Key",
            "Android Package Kernel",
            "Android Package Keep"
        ),
        answer = "a",
    ),
    QuizEntity(
        id = 7,
        question = "What is the Android Virtual Device (AVD) in app development?",
        options = listOf(" It is used to test apps on different device configurations ",
                " It is used to create and edit app layouts",
            "It is used to debug app code" ,
        "It is used to package and distribute apps" ),
        answer = "a",
    ),
    QuizEntity(
        id = 8,
        question = "Which of the following is not a type of Service?",
        options = listOf("Started Service", "Bound Service", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 9,
        question = "Which of the following is not a type of Broadcast Receiver?",
        options = listOf(
            "Ordered Broadcast",
            "Sticky Broadcast",
            "None of the above",
            "Both a and b"
        ),
        answer = "c",
    ),
    QuizEntity(
        id = 10,
        question = "Which of the following is not a type of Content Provider?",
        options = listOf("Single Process", "Multi Process", "None of the above", "Both a and b"),
        answer = "c",
    ),
    QuizEntity(
        id = 11,
        question = "hich of the following is not an activity lifecycle callback method?",
        options = listOf("onCreate()", "onStart()", "onResume()", "onBack()"),
        answer = "d",
    ),
    QuizEntity(
        id = 12,
        question = "What is the minimum API level required to use Android's ConstraintLayout?",
        options = listOf("API 14", "API 15", "API 16", "API 17"),
        answer = "c",
    ),
    QuizEntity(
        id = 13,
        question = "What is the base class for all Android views?",
        options = listOf("View", "ViewGroup", "TextView", "LinearLayout"),
        answer = "a",
    ),

    QuizEntity(
        id = 14,
        question = "Which of the following is not a valid resource type in Android?",
        options = listOf("drawable", "string", "layout", "widget"),
        answer = "d",
    ),
    QuizEntity(
        id = 15,
        question = "Which of the following is not a valid layout attribute in Android?",
        options = listOf("layout_width", "layout_height", "layout_margin", "layout_padding"),
        answer = "d",
    ),
)
