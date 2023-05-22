package com.hoon.mycam.main.inquiry

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hoon.data.inquiry.model.BasedInfoState
import com.hoon.data.inquiry.model.ImageInfoState
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainInquiryDetailBinding
import com.hoon.mycam.utils.GridSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InquiryDetailFragment: Fragment(R.layout.fragment_main_inquiry_detail) {
    private var _binding: FragmentMainInquiryDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: InquiryDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainInquiryDetailBinding.bind(view)
        _binding?.lifecycleOwner = this

        val args: InquiryDetailFragmentArgs by navArgs()

        _binding?.basedItem = args.basedInfoVo

        val inquiryDetailRvAdapter = InquiryDetailRvAdapter()

        CoroutineScope(Dispatchers.IO).launch {
            args.basedInfoVo.contentId?.let {
                viewModel.getImageInfo(it.toInt())
            }
        }

        binding.apply {
            campingImageRv.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = inquiryDetailRvAdapter
            }

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    this@InquiryDetailFragment.viewModel.imageInfo.collect {
                        when (it) {
                            is ImageInfoState.Success -> {
                                inquiryDetailRvAdapter.submitData(it.imageInfoList)
                            }
                            is ImageInfoState.Failure -> {

                            }
                            else -> {

                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}