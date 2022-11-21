package com.sundar.curriculumvitaeapp.ui.main.nav.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sundar.curriculumvitaeapp.R
import com.sundar.curriculumvitaeapp.databinding.FragmentProfileEditBinding


class ProfileEditFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentProfileEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val fabAdd = activity?.findViewById<FloatingActionButton>(R.id.fab_action)
        fabAdd?.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,R.drawable.ic_baseline_done_24,null) })
        fabAdd?.setOnClickListener {
            validateDataAndSave()
        }

        val toolBar = activity?.findViewById<TextView>(R.id.tv_title)
        toolBar?.text = "Edit Profile Information"
    }

    private fun validateDataAndSave() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileEditFragment()
    }
}