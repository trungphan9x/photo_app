package com.trung.photoapp.ui.activity.home

import android.os.Bundle
import com.trung.photoapp.R
import com.trung.photoapp.core.BaseActivity
import com.trung.photoapp.core.CustomPagerAdapter
import com.trung.photoapp.databinding.ActivityHomeBinding
import com.trung.photoapp.ui.fragment.listphoto.listphoto1.ListAFragment
import com.trung.photoapp.ui.fragment.listphoto.listphoto2.ListBFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel by viewModel(HomeViewModel::class)

    override fun getLayoutResId() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.pager.adapter = CustomPagerAdapter(
            supportFragmentManager,
            arrayListOf(ListAFragment(), ListBFragment()),
            arrayListOf("List A", "List B")
        )

        binding.tabLayout.setupWithViewPager(binding.pager)
    }
}
