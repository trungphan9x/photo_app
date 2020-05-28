package com.trung.photoapp.ui.fragment.listphoto.listphoto1

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseFragment
import com.trung.photoapp.databinding.FragmentListABinding
import com.trung.photoapp.ui.activity.detail.DetailActivity
import com.trung.photoapp.ui.activity.home.HomeViewModel
import com.trung.photoapp.ui.fragment.listphoto.ListPhotoAdapterWithDiffCallback
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListAFragment : BaseFragment<FragmentListABinding>() {

    private val viewModel: ListAViewModel by viewModel()
    private val homeViewModel: HomeViewModel by sharedViewModel()
    private val adapterA = ListPhotoAdapterWithDiffCallback()

    override fun getLayoutResId() = R.layout.fragment_list_a

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        binding.vm = viewModel
        binding.rvListA.adapter = adapterA

        //Turn on observe from xml layout for livedata variables
        binding.lifecycleOwner = this
//        viewModel.allPhoto.observe(viewLifecycleOwner, Observer {
//            adapterA.setIetms(it)
//        })

        adapterA.setOnItemClickListener { i, photoDetailEntity ->
            DetailActivity.startActivity(requireActivity(), photoDetailEntity)
        }

        homeViewModel.searchLiveData.observe(viewLifecycleOwner, Observer { newText ->
            adapterA.filter.filter(newText)
        })
    }
}