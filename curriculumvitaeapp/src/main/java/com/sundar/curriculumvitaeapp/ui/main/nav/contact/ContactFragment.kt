package com.sundar.curriculumvitaeapp.ui.main.nav.contact

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
import com.sundar.curriculumvitaeapp.databinding.FragmentContactBinding
import com.sundar.curriculumvitaeapp.ui.main.nav.contact.adapter.ContactAdapter

class ContactFragment : Fragment() {

    companion object {
        fun newInstance() = ContactFragment()
    }

    private lateinit var viewModel: ContactViewModel
    private lateinit var binding: FragmentContactBinding
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        initRecyclerView()
        val fabAdd = activity?.findViewById<FloatingActionButton>(R.id.fab_action)
        fabAdd?.setOnClickListener {
            Toast.makeText(context, "Work fragment", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        contactAdapter = ContactAdapter {  }
        contactAdapter.submitList(viewModel.contactList)
        with(binding.rvContact){
            adapter = contactAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}