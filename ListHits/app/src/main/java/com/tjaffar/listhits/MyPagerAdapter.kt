package com.tjaffar.listhits


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.res.TypedArrayUtils.getString
import android.view.View
import android.widget.TextView
import java.io.Serializable

class MyPagerAdapter (fragmentManager: FragmentManager, article : Serializable) : FragmentPagerAdapter(fragmentManager)
{

    private var article = article


    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return FirstFragment.newInstance(article)
        return SecondFragment.newInstance(article)
        //return (if (position == 0) FirstFragment().newInstance else SecondFragment())
    }

    override fun getCount(): Int {
        return (2)
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (position == 0)
            return "Sneak Peak"
        return "Full Article"
    }
}