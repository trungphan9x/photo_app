package com.trung.photoapp.ui.fragment.listphoto.listphoto2

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseFragment
import com.trung.photoapp.databinding.FragmentListBBinding
import com.trung.photoapp.ui.activity.detail.DetailActivity
import com.trung.photoapp.ui.activity.home.HomeViewModel
import com.trung.photoapp.ui.fragment.listphoto.ListPhotoAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListBFragment : BaseFragment<FragmentListBBinding>() {
    private val viewModel: ListBViewModel by viewModel()
    private val homeViewModel: HomeViewModel by sharedViewModel()
    private val adapterB = ListPhotoAdapter()

    override fun getLayoutResId() = R.layout.fragment_list_b

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.rvListB.adapter = adapterB
        viewModel.allPhoto.observe(viewLifecycleOwner, Observer {
            adapterB.setIetms(it)
        })

        adapterB.setOnItemClickListener { i, photoDetailEntity ->
            DetailActivity.startActivity(requireActivity(), photoDetailEntity)
        }

        homeViewModel.searchLiveData.observe(viewLifecycleOwner, Observer { newText ->
            adapterB.filter.filter(newText)
        })
    }
}