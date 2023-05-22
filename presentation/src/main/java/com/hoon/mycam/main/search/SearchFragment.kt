package com.hoon.mycam.main.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragment_main_search) {
    private var _binding: FragmentMainSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainSearchBinding.bind(view)
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