package com.miu.mdp.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.miu.mdp.R
import com.miu.mdp.databinding.FragmentQuizBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : Fragment(), View.OnClickListener {


    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quizViewModel.currentQuiz.observe(viewLifecycleOwner) { quiz ->
            binding.quizQuestion.text = "${quizViewModel.currentQuestionNumber}. ${quiz.question}"
            binding.quizOptionA.text = quiz.options[0]
            binding.quizOptionB.text = quiz.options[1]
            binding.quizOptionC.text = quiz.options[2]
            binding.quizOptionD.text = quiz.options[3]
        }

        binding.quizOptionA.setOnClickListener(this)
        binding.quizOptionB.setOnClickListener(this)
        binding.quizOptionC.setOnClickListener(this)
        binding.quizOptionD.setOnClickListener(this)

        binding.quizNextBtn.setOnClickListener {
            if (quizViewModel.currentQuestionNumber >= quizViewModel.totalQuestionToAnswer) {
                val directions = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                findNavController().navigate(directions)
            } else {
                quizViewModel.loadNextQuestion()
            }
            resetOptions()
        }

        quizViewModel.resetLiveData.observe(viewLifecycleOwner) {
            resetOptions()
        }
        binding.quizHomeBtn.setOnClickListener {
            resetOptions()
            val directions = QuizFragmentDirections.actionQuizFragmentToHomeFragment()
            findNavController().navigate(directions)
        }

    }

    private fun validateOptionsSelected(option: Button, selectedAnswer: String) {
        val correctAnswer = quizViewModel.getCorrectAnswer(selectedAnswer)
        val isCorrect = selectedAnswer == correctAnswer
        setButtonBackground(option, isCorrect)
        if (!isCorrect) {
            highlightCorrectAnswer(correctAnswer)
        }

        setButtonState(false)
        if (quizViewModel.currentQuestionNumber >= quizViewModel.totalQuestionToAnswer) {
            binding.quizNextBtn.text = getString(R.string.show_results)
        }
        binding.quizNextBtn.visibility = View.VISIBLE
    }

    private fun setButtonState(enable: Boolean) {
        binding.quizOptionA.isEnabled = enable
        binding.quizOptionB.isEnabled = enable
        binding.quizOptionC.isEnabled = enable
        binding.quizOptionD.isEnabled = enable
    }

    private fun highlightCorrectAnswer(correctAnswer: String) {
        when (correctAnswer) {
            "a" -> setButtonBackground(binding.quizOptionA, true)
            "b" -> setButtonBackground(binding.quizOptionB, true)
            "c" -> setButtonBackground(binding.quizOptionC, true)
            "d" -> setButtonBackground(binding.quizOptionD, true)
        }
    }

    private fun setButtonBackground(button: Button, isCorrect: Boolean) {
        button.backgroundTintList =
            ContextCompat.getColorStateList(
                requireContext(),
                if (isCorrect) R.color.colorCorrect else R.color.colorWrong
            )
    }

    private fun resetOptions() {
        binding.quizNextBtn.visibility = View.GONE
        setButtonState(true)
        binding.quizOptionA.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.colorBackground)
        binding.quizOptionB.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.colorBackground)
        binding.quizOptionC.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.colorBackground)
        binding.quizOptionD.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.colorBackground)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.quizOptionA.id -> {
                validateOptionsSelected(binding.quizOptionA, "a")
            }
            binding.quizOptionB.id -> {
                validateOptionsSelected(binding.quizOptionB, "b")
            }
            binding.quizOptionC.id -> {
                validateOptionsSelected(binding.quizOptionC, "c")
            }
            binding.quizOptionD.id -> {
                validateOptionsSelected(binding.quizOptionD, "d")
            }
        }
    }


}