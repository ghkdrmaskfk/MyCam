package com.hoon.mycam.main.community

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainCommunityBinding
import com.hoon.mycam.databinding.FragmentMainHomeBinding
import com.hoon.mycam.main.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommunityFragment: Fragment(R.layout.fragment_main_community) {
    private var _binding: FragmentMainCommunityBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CommunityViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainCommunityBinding.bind(view)
        _binding?.lifecycleOwner = this
        _binding?.fragment = this
        _binding?.viewModel = viewModel

        binding.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}