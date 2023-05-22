package com.hoon.mycam.main.inquiry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hoon.domain.inquiry.model.ImageInfoVo
import com.hoon.mycam.databinding.RvCampingImageBinding

class InquiryDetailRvAdapter: PagingDataAdapter<ImageInfoVo, RecyclerView.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageVH(RvCampingImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageVH -> {
                getItem(position)?.let {
                    holder.bind(it)
                }
            }
        }
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<ImageInfoVo>(){
            override fun areItemsTheSame(oldItem: ImageInfoVo, newItem: ImageInfoVo): Boolean {
                return oldItem.contentId == newItem.contentId
            }

            override fun areContentsTheSame(oldItem: ImageInfoVo, newItem: ImageInfoVo): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ImageVH(private val binding: RvCampingImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: ImageInfoVo){
            binding.apply {
                imageItem = data
            }
        }
    }
}