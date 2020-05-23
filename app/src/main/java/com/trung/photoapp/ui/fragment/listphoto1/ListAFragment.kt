package com.trung.photoapp.ui.fragment.listphoto1

import com.trung.photoapp.R
import com.trung.photoapp.core.BaseFragment
import com.trung.photoapp.databinding.FragmentListABinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListAFragment : BaseFragment<FragmentListABinding>() {

    private val viewModel by viewModel(ListAViewModel::class)

    override fun getLayoutResId() = R.layout.fragment_list_a


    override fun viewDidLoad() {
        binding.vm = viewModel
    }

}