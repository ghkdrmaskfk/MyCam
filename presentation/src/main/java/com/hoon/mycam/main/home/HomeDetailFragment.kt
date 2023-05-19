package com.hoon.mycam.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainHomeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDetailFragment: Fragment(R.layout.fragment_main_home_detail) {
    private var _binding: FragmentMainHomeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainHomeDetailBinding.bind(view)
        _binding?.lifecycleOwner = this

        val args: HomeDetailFragmentArgs by navArgs()

        _binding?.campingBasedItem = args.campingBasedData

        binding.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}