package com.sundar.curriculumvitaeapp.ui.main.nav.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sundar.curriculumvitaeapp.utils.HomeConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val introDatas : MutableStateFlow<List<Pair<String,String?>>> = MutableStateFlow(mutableListOf())
    val toolsAndTechnology : MutableStateFlow<MutableList<Pair<String,MutableList<String>>>> = MutableStateFlow(mutableListOf())
    init {
        viewModelScope.launch {
            introDatas.emit(mutableListOf(
                Pair(HomeConstants.FULL_NAME, "Sundar Parajuli"),
                Pair(HomeConstants.INTRO, "Software developer"),
                Pair(HomeConstants.CAREER_NOTE, "Completed on-campus studies and currently taking distance education courses to complete a Master's Degree in computer science (Available for full-time, w-2 employment)."),
            ))

            toolsAndTechnology.emit(mutableListOf(
                Pair(HomeConstants.LANGUAGES, mutableListOf("Java","JavaScript","PL/SQL")),
                Pair(HomeConstants.FRAMEWORKS_WEB, mutableListOf("Spring(Boot,Mvc,Security)","Hibernate","JDBC")),
                Pair(HomeConstants.MICROSERVICES_CLOUD, mutableListOf("AWS","GCP","Docker","Kubernetes","kafka")),
                Pair(HomeConstants.DATABASES, mutableListOf("Oracle PL/SQL","MySQL","MongoDB")),
                Pair(HomeConstants.TOOLS, mutableListOf("IntliJ IDEA","Maven","GitHub","GitLab","UML")),
            ))

        }

    }



}