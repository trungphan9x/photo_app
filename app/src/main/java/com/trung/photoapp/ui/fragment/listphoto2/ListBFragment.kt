package com.trung.photoapp.ui.fragment.listphoto2

import com.trung.photoapp.R
import com.trung.photoapp.core.BaseFragment
import com.trung.photoapp.databinding.FragmentListBBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListBFragment : BaseFragment<FragmentListBBinding>() {
    private val viewModel by viewModel(ListBViewModel::class)
    override fun getLayoutResId() = R.layout.fragment_list_b
    override fun viewDidLoad() {
        binding.vm = viewModel
    }
}