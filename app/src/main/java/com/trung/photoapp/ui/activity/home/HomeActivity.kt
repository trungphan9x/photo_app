package com.trung.photoapp.ui.activity.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
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

        binding.photoSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchLiveData.postValue(newText)
                return false
            }

        })

        binding.photoSearch.findViewById<ImageView>(R.id.search_close_btn).setOnClickListener {
            //remove keyword
            binding.photoSearch.findViewById<TextView>(R.id.search_src_text).text = ""

            //close soft keyboard
            val view: View? = this.currentFocus
            if (view != null) {
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}
