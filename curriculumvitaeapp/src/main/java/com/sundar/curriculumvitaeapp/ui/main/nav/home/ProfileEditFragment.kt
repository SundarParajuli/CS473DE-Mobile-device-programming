package com.sundar.curriculumvitaeapp.ui.main.nav.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.sundar.curriculumvitaeapp.R
import com.sundar.curriculumvitaeapp.databinding.FragmentProfileEditBinding
import kotlinx.coroutines.launch


class ProfileEditFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentProfileEditBinding
    private val languageItems:MutableList<String> = mutableListOf()

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

        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        val fabAdd = activity?.findViewById<FloatingActionButton>(R.id.fab_action)
        fabAdd?.setImageDrawable(context?.let { ResourcesCompat.getDrawable(it.resources,R.drawable.ic_baseline_done_24,null) })
        fabAdd?.setOnClickListener {
            validateDataAndSave()
        }
        binding.recipientInputET.setOnEditorActionListener {ed, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                addNewChip(ed.text.toString(),binding.recipientGroupFL)
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun validateDataAndSave() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.introDatas.emit(mutableListOf(
                Pair(HomeConstants.FULL_NAME, binding.tilName.getString()),
                Pair(HomeConstants.INTRO, binding.tilIntro.getString()),
                Pair(HomeConstants.CAREER_NOTE, binding.tilCareerNote.getString()),
            ))

            viewModel.toolsAndTechnology.emit(mutableListOf(
                Pair(HomeConstants.LANGUAGES, languageItems),
                Pair(HomeConstants.FRAMEWORKS_WEB, mutableListOf("Luffy","law")),
                Pair(HomeConstants.MICROSERVICES_CLOUD, mutableListOf("Luff","law")),
                Pair(HomeConstants.DATABASES, mutableListOf()),
                Pair(HomeConstants.TOOLS, mutableListOf()),
            ))

//
//            viewModel.fullName.emit(binding.tilName.editText?.text.toString())
//            viewModel.intro.emit(binding.tilIntro.editText?.text.toString())
//             findNavController().navigate(HomeFragmentDirections.actionHome())

        }
    }
    private fun addNewChip(
        person: String,
        chipGroup: FlexboxLayout,
    ) {
        languageItems.add(person)
        val chip = Chip(context)
        chip.text = person
        chip.chipIcon = ContextCompat.getDrawable(requireContext(), R.mipmap.ic_launcher_round)
        chip.isCloseIconVisible = true
        chipGroup.addView(chip as View, chipGroup.childCount - 1)
        chip.setOnCloseIconClickListener {
            chipGroup.removeView(chip as View)
            languageItems.remove(person)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileEditFragment()
    }

    private fun TextInputLayout.getString():String{
        return this.editText?.text.toString()
    }

    object HomeConstants{
        const val FULL_NAME = "full_name"
        const val INTRO = "intro"
        const val CAREER_NOTE = "career_note"

        const val LANGUAGES = "languages"
        const val FRAMEWORKS_WEB = "frameworks_web"
        const val MICROSERVICES_CLOUD = "microservices_cloud"
        const val DATABASES = "databases"
        const val TOOLS = "tools"
    }
}