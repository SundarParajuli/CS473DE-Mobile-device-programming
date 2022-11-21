package com.sundar.curriculumvitaeapp.ui.main.nav.contact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundar.curriculumvitaeapp.data.Contact
import com.sundar.curriculumvitaeapp.databinding.ItemContactBinding

class ContactAdapter(var onItemClick: ((Contact) -> Unit)?) : ListAdapter<Contact, ContactAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener { onItemClick?.let { it1 -> it1(currentItem) } }
    }

    inner class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact){
            Glide.with(binding.root.context).load(contact.imageUrl).into(binding.ivLogo)
            binding.tvContact.text= contact.contact
            binding.tvContactType.text= contact.contactType

        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact) =
//            oldItem.itemId == newItem.itemId
            false
        //TODO:: work on handling diff
        override fun areContentsTheSame(oldItem: Contact, newItem: Contact) =
            oldItem == newItem
    }
}