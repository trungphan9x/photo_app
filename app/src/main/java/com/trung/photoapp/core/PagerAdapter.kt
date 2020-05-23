package com.trung.photoapp.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(
    fm: FragmentManager,
    private val fragments: ArrayList<Fragment>,
    private val titles: ArrayList<String>? = null
) : FragmentStatePagerAdapter(fm) {
    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? {
        titles?.let { arrayList ->
            arrayList.getOrNull(position)?.let {
                return it
            }
        }
        return null
    }
}

