package com.sundar.curriculumvitaeapp.ui.main.nav.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundar.curriculumvitaeapp.data.Education
import com.sundar.curriculumvitaeapp.databinding.ItemEducationBinding

class EducationAdapter(var onItemClick: ((Education) -> Unit)?) : ListAdapter<Education, EducationAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEducationBinding
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

    inner class ViewHolder(private val binding: ItemEducationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(education: Education){
            Glide.with(binding.root.context).load(education.imageUrl).into(binding.ivLogo)
            binding.tvName.text= education.collegeTitle
            binding.tvDegreeTitle.text= education.degreeTitle
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Education>() {
        override fun areItemsTheSame(oldItem: Education, newItem: Education) =
//            oldItem.itemId == newItem.itemId
            false
        //TODO:: work on handling diff
        override fun areContentsTheSame(oldItem: Education, newItem: Education) =
            oldItem == newItem
    }
}