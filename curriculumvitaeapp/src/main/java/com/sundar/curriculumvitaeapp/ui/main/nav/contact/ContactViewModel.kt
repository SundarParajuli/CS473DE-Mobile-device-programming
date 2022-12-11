package com.sundar.curriculumvitaeapp.ui.main.nav.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sundar.curriculumvitaeapp.data.Contact
import com.sundar.curriculumvitaeapp.utils.SharedPrefConstants
import com.sundar.curriculumvitaeapp.utils.SharedPrefsUtil

class ContactViewModel(context: Application) : AndroidViewModel(context) {
    val contactList = mutableListOf<Contact>()
    init {
        val cList = SharedPrefsUtil.retrieveList(context, SharedPrefConstants.CONTACTS)
        cList?.let {
            for (item in cList) {
                if (item is Contact) {
                    contactList.add(item)
                }
            }
        }
    }
}