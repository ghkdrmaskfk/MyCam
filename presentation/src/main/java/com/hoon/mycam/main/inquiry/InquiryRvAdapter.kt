package com.hoon.mycam.main.inquiry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hoon.domain.inquiry.model.BasedInfoVo
import com.hoon.mycam.databinding.RvCampingInfoBinding

class InquiryRvAdapter(private val navController: NavController): PagingDataAdapter<BasedInfoVo, RecyclerView.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BasedVH(RvCampingInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BasedVH -> {
                getItem(position)?.let {
                    holder.bind(it)
                }
            }
        }
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<BasedInfoVo>(){
            override fun areItemsTheSame(oldItem: BasedInfoVo, newItem: BasedInfoVo): Boolean {
                return oldItem.contentId == newItem.contentId
            }

            override fun areContentsTheSame(oldItem: BasedInfoVo, newItem: BasedInfoVo): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class BasedVH(private val binding: RvCampingInfoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: BasedInfoVo){
            binding.apply {
                basedItem = data
                basedVH = this@BasedVH
            }
        }

        fun detailViewClicked(data: BasedInfoVo) {
            val action = InquiryFragmentDirections.actionInquiryFragmentToInquiryDetailFragment(data)
            navController.navigate(action)
        }
    }
}