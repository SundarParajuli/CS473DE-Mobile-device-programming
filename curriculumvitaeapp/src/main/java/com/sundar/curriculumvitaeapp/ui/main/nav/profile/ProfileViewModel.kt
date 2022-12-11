package com.sundar.curriculumvitaeapp.ui.main.nav.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sundar.curriculumvitaeapp.data.Certification
import com.sundar.curriculumvitaeapp.data.Education
import com.sundar.curriculumvitaeapp.utils.SharedPrefConstants
import com.sundar.curriculumvitaeapp.utils.SharedPrefsUtil

class ProfileViewModel(var context:Application) : AndroidViewModel(context) {
    var educationList = mutableListOf<Education>()
    val certificationList = mutableListOf<Certification>()
    init {
        initEducationList()
        initCertificationList()
    }

    private fun initCertificationList() {
        val cerList = SharedPrefsUtil.retrieveList(context, SharedPrefConstants.CERTIFICATIONS)
        cerList?.let {
            for (item in cerList) {
                if (item is Certification) {
                    certificationList.add(item)
                }
            }
        }
    }

    private fun initEducationList() {
       val eduList = SharedPrefsUtil.retrieveList(context, SharedPrefConstants.EDUCATIONS)
        eduList?.let {
            for (item in eduList){
                if (item is Education){
                    educationList.add(item)
                }
            }
        }

    }

    fun <T> addItem(item:T){
        when(item){
            is Education -> educationList.add(item)
            is Certification -> certificationList.add(item)
        }
    }
}