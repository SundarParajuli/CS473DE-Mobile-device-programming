package com.miu.mdp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.miu.mdp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStartQuiz.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToQuizFragment()
            findNavController().navigate(directions)
        }

        binding.buttonResultAnalysis.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToResultAnalysisFragment()
            findNavController().navigate(directions)
        }
    }

}