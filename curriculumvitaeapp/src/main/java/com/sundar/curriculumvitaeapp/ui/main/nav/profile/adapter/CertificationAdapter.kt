package com.sundar.curriculumvitaeapp.ui.main.nav.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundar.curriculumvitaeapp.data.Certification
import com.sundar.curriculumvitaeapp.databinding.ItemCertificationBinding

class CertificationAdapter(var onItemClick: ((Certification) -> Unit)?) : ListAdapter<Certification, CertificationAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCertificationBinding
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

    inner class ViewHolder(private val binding: ItemCertificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(certification: Certification){
            Glide.with(binding.root.context).load(certification.imageUrl).into(binding.ivLogo)
            binding.tvCertificationTitle.text= certification.certificationTitle

        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Certification>() {
        override fun areItemsTheSame(oldItem: Certification, newItem: Certification) =
//            oldItem.itemId == newItem.itemId
            false
        //TODO:: work on handling diff
        override fun areContentsTheSame(oldItem: Certification, newItem: Certification) =
            oldItem == newItem
    }
}