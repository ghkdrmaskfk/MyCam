package com.hoon.mycam.main.market

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainMarketBinding
import com.hoon.mycam.main.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment: Fragment(R.layout.fragment_main_market) {
    private var _binding: FragmentMainMarketBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MarketViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainMarketBinding.bind(view)
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