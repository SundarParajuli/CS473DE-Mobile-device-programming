package com.sundar.curriculumvitaeapp.ui.main.nav.work

import androidx.lifecycle.ViewModel
import com.sundar.curriculumvitaeapp.data.Work

class WorkViewModel : ViewModel() {
    val workExperienceList = mutableListOf<Work>()

    init {
        val work = Work(
            "",
            "Android dev",
            "Ebpearls pty ltd",
            "jan 2015- july 2019",
            "Kathmandu, Nepal",
            "Developing android apps"
        )
        val work2 = Work(
            "",
            "Android dev",
            "Hello world",
            "jan 2015- july 2019",
            "Kathmandu, Nepal",
            "Developing android apps"
        )
        addWork(work)
        addWork(work2)
    }
    fun addWork(work: Work){
        workExperienceList.add(work)
    }
}