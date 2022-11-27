package com.sundar.curriculumvitaeapp.ui.main.nav.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sundar.curriculumvitaeapp.R
import com.sundar.curriculumvitaeapp.databinding.FragmentProfileBinding
import com.sundar.curriculumvitaeapp.ui.main.nav.profile.adapter.CertificationAdapter
import com.sundar.curriculumvitaeapp.ui.main.nav.profile.adapter.EducationAdapter

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding
    private lateinit var educationAdapter: EducationAdapter
    private lateinit var certificationAdapter: CertificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        initRecyclerView()
        val fabAdd = activity?.findViewById<FloatingActionButton>(R.id.fab_action)
        fabAdd?.setImageDrawable(ResourcesCompat.getDrawable(resources,R.drawable.ic_baseline_create_24,null))
        fabAdd?.visibility = View.VISIBLE
        fabAdd?.setOnClickListener {
            Toast.makeText(context, "Work fragment", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        initEducationRecyclerView()
        initCertificationRecyclerView()
    }

    private fun initEducationRecyclerView() {
        this.educationAdapter = EducationAdapter {}
        educationAdapter.submitList(viewModel.educationList)
        binding.rvCollege.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = educationAdapter
        }
    }

    private fun initCertificationRecyclerView() {
        this.certificationAdapter = CertificationAdapter { }
        certificationAdapter.submitList(viewModel.certificationList)
        binding.rvCertification.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = certificationAdapter
        }
    }


}