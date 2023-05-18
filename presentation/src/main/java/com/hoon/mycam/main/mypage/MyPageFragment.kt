package com.hoon.mycam.main.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainCommunityBinding
import com.hoon.mycam.databinding.FragmentMainMyPageBinding
import com.hoon.mycam.main.community.CommunityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment: Fragment(R.layout.fragment_main_my_page) {
    private var _binding: FragmentMainMyPageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainMyPageBinding.bind(view)
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