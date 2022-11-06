package com.sundar.quizapp

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.sundar.quizapp.databinding.ActivityQuizBinding
import java.util.*

class QuizActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    //List<Triple<Question,Right Answer index,List<Possible answers>
    private val quizList = mutableListOf<Triple<String, Int, List<String>>>()
    private var score = 0
    private var selectedRadio = -1
    private var selectedCheckBox = -1
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuizList()
        initDataBinding()
        inflateViews()
        initButtonListeners()
    }

    private fun initButtonListeners() {
        binding.btnClear.setOnClickListener {
            clearAction()
        }
        binding.cbFirst.setOnCheckedChangeListener(this)
        binding.cbSecond.setOnCheckedChangeListener(this)
        binding.cbThird.setOnCheckedChangeListener(this)
        binding.btnSubmit.setOnClickListener {
            binding.rgFirstQuestion.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbFirstOption -> {
                        selectedRadio = 0
                    }
                    R.id.rbSecondOption -> {
                        selectedRadio = 1
                    }
                    R.id.rbThirdOption -> {
                        selectedRadio = 2
                    }
                }
            }
            calculateResult(selectedRadio, 0)
            calculateResult(selectedCheckBox, 1)


            AlertDialog.Builder(this)
                .setTitle(getAlertDialogTitleAndMessage().first)
                .setMessage(getAlertDialogTitleAndMessage().second)
                .setPositiveButton(
                    "ok"
                ) { _, _ -> clearAction() }
                .show()


        }
    }

    private fun clearAction() {
        binding.rgFirstQuestion.clearCheck()
        binding.cbFirst.isChecked = false
        binding.cbSecond.isChecked = false
        binding.cbThird.isChecked = false
        score = 0
        selectedRadio = -1
        selectedCheckBox = -1
    }


    private fun getAlertDialogTitleAndMessage(): Pair<String, String> {
        var title = ""
        var message = ""
        when (score) {
            0 -> {
                title = "Try Again!"
                message =
                    "Try Again! You submitted on ${Calendar.getInstance().time}, You achieved $score%"
            }
            50 -> {
                title = "Congratulations!"
                message =
                    "Congratulations! You submitted on ${Calendar.getInstance().time}, You achieved $score%"

            }
            100 -> {
                title = "Congratulations!"
                message =
                    "Congratulations! You submitted on ${Calendar.getInstance().time}, You achieved $score%"

            }
        }
        return Pair(title, message)
    }

    private fun calculateResult(selection: Int, questionIndex: Int): Int {
        if (selection == quizList[questionIndex].second) {
            score += 50
        }
        return score
    }

    private fun initDataBinding() {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun inflateViews() {
        binding.tvQuestionFirst.text = quizList[0].first
        binding.rbFirstOption.text = quizList[0].third[0]
        binding.rbSecondOption.text = quizList[0].third[1]
        binding.rbThirdOption.text = quizList[0].third[2]

        binding.tvQuestionSecond.text = quizList[1].first
        binding.cbFirst.text = quizList[1].third[0]
        binding.cbSecond.text = quizList[1].third[1]
        binding.cbThird.text = quizList[1].third[2]

    }

    private fun initQuizList() {
        quizList.add(
            Triple(
                "What is a correct syntax to output \"Hello World\" in Kotlin?",
                1,
                listOf(
                    "Console.WriteLine(\"Hello World\");",
                    "println(\"Hello World\")",
                    "System.out.printline(\"Hello World\")\n"
                )
            )
        )
        quizList.add(
            Triple(
                "How can you create a variable with the numeric value 5?",
                1,
                listOf(
                    "int num = 5",
                    "val num = 5 ",
                    "num = 5 int"
                )
            )
        )

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.cbFirst -> {
                if (isChecked) {
                    binding.cbSecond.isChecked = false
                    binding.cbThird.isChecked = false
                    selectedCheckBox = 0
                }
            }
            R.id.cbSecond -> {
                if (isChecked) {
                    binding.cbThird.isChecked = false
                    binding.cbFirst.isChecked = false
                    selectedCheckBox = 1
                }

            }
            R.id.cbThird -> {
                if (isChecked) {
                    binding.cbFirst.isChecked = false
                    binding.cbSecond.isChecked = false
                    selectedCheckBox = 2
                }

            }
        }
    }

}
