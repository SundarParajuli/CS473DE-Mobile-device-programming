package com.sundar.curriculumvitaeapp.ui.main.nav.contact

import androidx.lifecycle.ViewModel
import com.sundar.curriculumvitaeapp.data.Contact

class ContactViewModel : ViewModel() {
    val contactList = mutableListOf<Contact>()
    init {
        val contact = Contact(
            "",
            "abc@gmail.com",
        "email"
        )
        val contact2 = Contact(
            "",
            "123-456-7890",
        "phone"
        )
        addContact(contact)
        addContact(contact2)
    }

    fun addContact(contact: Contact){
        contactList.add(contact)
    }
}