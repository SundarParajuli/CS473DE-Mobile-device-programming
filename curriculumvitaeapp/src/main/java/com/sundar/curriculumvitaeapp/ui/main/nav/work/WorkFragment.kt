package com.sundar.curriculumvitaeapp.ui.main.nav.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sundar.curriculumvitaeapp.R
import com.sundar.curriculumvitaeapp.databinding.FragmentWorkBinding
import com.sundar.curriculumvitaeapp.ui.main.nav.work.adapter.WorkAdapter

class WorkFragment : Fragment() {
    private var workFragment:WorkFragment? = null
    companion object {
        fun newInstance() = WorkFragment()
    }
    fun gg(): WorkFragment? {
        return workFragment
    }
    private lateinit var viewModel: WorkViewModel
    private lateinit var binding: FragmentWorkBinding
    private lateinit var workAdapter: WorkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkBinding.inflate( inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workFragment = this
        viewModel = ViewModelProvider(this)[WorkViewModel::class.java]
        initRecyclerView()
        val fabAdd = activity?.findViewById<FloatingActionButton>(R.id.fab_action)
        fabAdd?.setOnClickListener {
            Toast.makeText(context, "Work fragment", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        workAdapter = WorkAdapter {  }
        workAdapter.submitList(viewModel.workExperienceList)
        with(binding.rvWork){
            layoutManager = LinearLayoutManager(context)
            adapter = workAdapter
        }
    }


}