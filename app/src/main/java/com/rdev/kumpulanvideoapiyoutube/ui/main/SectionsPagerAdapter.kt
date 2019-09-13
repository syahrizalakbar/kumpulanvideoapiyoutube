package com.rdev.kumpulanvideoapiyoutube.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rdev.kumpulanvideoapiyoutube.DestinationFragment
import com.rdev.kumpulanvideoapiyoutube.FootballFragment
import com.rdev.kumpulanvideoapiyoutube.R
import com.rdev.kumpulanvideoapiyoutube.TravellerFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> fragment = FootballFragment()
            1 -> fragment = TravellerFragment()
            2 -> fragment = DestinationFragment()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var nameTabs = ""
        when (position) {
            0 -> nameTabs = "Football"
            1 -> nameTabs = "Traveller"
            2 -> nameTabs = "Destination"
        }
        return nameTabs
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}