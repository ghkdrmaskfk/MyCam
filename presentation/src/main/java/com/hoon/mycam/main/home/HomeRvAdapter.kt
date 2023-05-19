package com.hoon.mycam.main.home

import android.content.ClipData.Item
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hoon.data.lookup.model.HomeRecordItem
import com.hoon.domain.lookup.model.CampingBasedInfoVo
import com.hoon.mycam.R
import com.hoon.mycam.databinding.RvCampingInfoBinding

class HomeRvAdapter(private val navController: NavController): PagingDataAdapter<CampingBasedInfoVo, RecyclerView.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CampingVH(RvCampingInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CampingVH -> {
                getItem(position)?.let {
                    holder.bind(it)
                }
            }
        }
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<CampingBasedInfoVo>(){
            override fun areItemsTheSame(oldItem: CampingBasedInfoVo, newItem: CampingBasedInfoVo): Boolean {
                return oldItem.contentId == newItem.contentId
            }

            override fun areContentsTheSame(oldItem: CampingBasedInfoVo, newItem: CampingBasedInfoVo): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class CampingVH(private val binding: RvCampingInfoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: CampingBasedInfoVo){
            binding.apply {
                campingBasedItem = data
                campingVH = this@CampingVH
            }
        }

        fun detailViewClicked(view: View) {
            navController.navigate(R.id.action_homeFragment_to_homeDetailFragment)
        }
    }
}