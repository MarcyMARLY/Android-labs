package com.example.msise.tabsapplab3.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.msise.tabsapplab3.fragments.CategoryFragment
import com.example.msise.tabsapplab3.fragments.RecentNewsFragment

class MainNewsAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RecentNewsFragment()
            1 -> CategoryFragment()
            else -> RecentNewsFragment()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Recent News"
            1 -> "Category"
            else -> "Recent News"
        }
    }
}