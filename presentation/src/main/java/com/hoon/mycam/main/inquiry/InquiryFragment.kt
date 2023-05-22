package com.hoon.mycam.main.inquiry

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.hoon.data.inquiry.model.BasedInfoState
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainInquiryBinding
import com.hoon.mycam.utils.GridSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InquiryFragment: Fragment(R.layout.fragment_main_inquiry) {
    private var _binding: FragmentMainInquiryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: InquiryViewModel by viewModels()
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainInquiryBinding.bind(view)
        _binding?.lifecycleOwner = this
        _binding?.fragment = this
        _binding?.viewModel = viewModel

        navController = Navigation.findNavController(view)
        val inquiryRvAdapter = InquiryRvAdapter(navController)

        binding.apply {
            campingBasedRv.apply {
                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                adapter = inquiryRvAdapter
                addItemDecoration(GridSpaceItemDecoration(2, 20))
            }

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    this@InquiryFragment.viewModel.basedInfo.collect {
                        when (it) {
                            is BasedInfoState.Success -> {
                                inquiryRvAdapter.submitData(it.basedInfoList)
                            }
                            is BasedInfoState.Failure -> {

                            }
                            else -> {

                            }
                        }
                    }
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.basedInfo()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}