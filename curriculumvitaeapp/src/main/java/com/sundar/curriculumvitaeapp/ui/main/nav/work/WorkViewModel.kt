package com.sundar.curriculumvitaeapp.ui.main.nav.work

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sundar.curriculumvitaeapp.data.Work
import com.sundar.curriculumvitaeapp.utils.SharedPrefConstants
import com.sundar.curriculumvitaeapp.utils.SharedPrefsUtil

class WorkViewModel(context: Application) : AndroidViewModel(context) {
    val workExperienceList = mutableListOf<Work>()

    init {
        val workList = SharedPrefsUtil.retrieveList(context, SharedPrefConstants.WORK_EXPERIENCES)
        workList?.let {
            for (item in workList) {
                if (item is Work) {
                    workExperienceList.add(item)
                }
            }
        }
    }
}