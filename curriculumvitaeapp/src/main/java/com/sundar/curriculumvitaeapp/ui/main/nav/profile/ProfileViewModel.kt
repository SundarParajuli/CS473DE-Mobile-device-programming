package com.sundar.curriculumvitaeapp.ui.main.nav.profile

import androidx.lifecycle.ViewModel
import com.sundar.curriculumvitaeapp.data.Certification
import com.sundar.curriculumvitaeapp.data.Education

class ProfileViewModel : ViewModel() {
    val educationList = mutableListOf<Education>()
    val certificationList = mutableListOf<Certification>()
    init {
        initEducationList()
        initCertificationList()
    }

    private fun initCertificationList() {

    }

    private fun initEducationList() {
        val education = Education("","Ambition Academy","High school")
        val educationBachelors = Education("","St. Xavier's college","BIM")
        educationList.add(education)
        educationList.add(educationBachelors)
        educationList.add(educationBachelors)
        educationList.add(educationBachelors)
    }

    fun <T> addItem(item:T){
        when(item){
            is Education -> educationList.add(item)
            is Certification -> certificationList.add(item)
        }
    }
}