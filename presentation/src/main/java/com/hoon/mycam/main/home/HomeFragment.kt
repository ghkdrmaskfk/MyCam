package com.hoon.mycam.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hoon.data.lookup.model.CampingBasedInfoState
import com.hoon.mycam.R
import com.hoon.mycam.databinding.FragmentMainHomeBinding
import com.hoon.mycam.main.GridSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_main_home) {
    private var _binding: FragmentMainHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainHomeBinding.bind(view)
        _binding?.lifecycleOwner = this
        _binding?.fragment = this
        _binding?.viewModel = viewModel

        navController = Navigation.findNavController(view)
        val homeRvAdapter = HomeRvAdapter(navController)

        binding.apply {
            campingBasedRv.apply {
                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                adapter = homeRvAdapter
                addItemDecoration(GridSpaceItemDecoration(2, 20))
            }

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    this@HomeFragment.viewModel.campingBasedInfo.collect {
                        when (it) {
                            is CampingBasedInfoState.Success -> {
                                homeRvAdapter.submitData(it.campingBasedInfoList)
                            }
                            is CampingBasedInfoState.Failure -> {

                            }
                            else -> {

                            }
                        }
                    }
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.campingBasedInfo()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}