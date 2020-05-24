package com.trung.photoapp.ui.fragment.listphoto.listphoto1

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseFragment
import com.trung.photoapp.databinding.FragmentListABinding
import com.trung.photoapp.ui.activity.detail.DetailActivity
import com.trung.photoapp.ui.fragment.listphoto.ListPhotoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListAFragment : BaseFragment<FragmentListABinding>() {

    private val viewModel: ListAViewModel by viewModel()
    private val adapter = ListPhotoAdapter()

    override fun getLayoutResId() = R.layout.fragment_list_a

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.vm = viewModel
        binding.rvListA.adapter = adapter
        viewModel.allPhoto.observe(viewLifecycleOwner, Observer {
            adapter.setIetms(it)
        })

        adapter.setOnItemClickListener { i, photoDetailEntity ->
            DetailActivity.startActivity(requireActivity(), photoDetailEntity)
        }
    }
}