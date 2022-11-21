package com.sundar.curriculumvitaeapp.ui.main.nav.work.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundar.curriculumvitaeapp.data.Work
import com.sundar.curriculumvitaeapp.databinding.ItemWorkBinding

class WorkAdapter(var onItemClick: ((Work) -> Unit)?) : ListAdapter<Work, WorkAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ItemWorkBinding
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

    inner class ViewHolder(private val binding:ItemWorkBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(work: Work){
            Glide.with(binding.root.context).load(work.imageUrl).into(binding.ivLogo)
            binding.tvPositionTitle.text= work.positionTitle
            binding.tvCompanyName.text = work.companyName
            binding.timeFrame.text= work.timeFrame
            binding.tvCompanyAddress.text= work.address
            binding.tvCompanyDescription.text= work.workDescription

        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Work>() {
        override fun areItemsTheSame(oldItem:Work , newItem: Work) =
//            oldItem.itemId == newItem.itemId
            false
        //TODO:: work on handling diff
        override fun areContentsTheSame(oldItem: Work, newItem:Work ) =
            oldItem == newItem
    }
}