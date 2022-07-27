package com.polinasmogi.viewpager.ui.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.polinasmogi.viewpager.ui.order.OrderFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    data: MutableLiveData<Bundle>
): FragmentStateAdapter(fragmentManager, lifecycle) {

    private lateinit var fragment: Fragment
    private lateinit var fragments: ArrayList<Fragment>
    private lateinit var context: Context
    private lateinit var data: MutableLiveData<Bundle>

    constructor(fragment: Fragment, fragments: ArrayList<Fragment>, data: MutableLiveData<Bundle>)
            : this(fragment.childFragmentManager, fragment.lifecycle, data) {
        this.fragment = fragment
        this.fragments = fragments
        this.data = data
        fragment.context?.let {
            this.context = it
        }
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = fragments[position]
        (fragment as OrderFragment).bindData(data)
        return fragments[position]
    }

    fun add(fragment: Fragment) {
        fragments.add(fragment)
    }

}