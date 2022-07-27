package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.polinasmogi.viewpager.R
import com.polinasmogi.viewpager.ui.adapter.ViewPagerAdapter

class OrderBookHostFragment : Fragment(R.layout.fragment_host) {

    private lateinit var viewModel: OrderViewModel

    private lateinit var viewPager: ViewPager2

    private val liveData = MutableLiveData(Bundle())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        val selectDesignFragment = SelectDesignFragment()
        val adapter = ViewPagerAdapter(
        this,
                arrayListOf(selectDesignFragment),
                liveData
        )

        val button = view.findViewById<Button>(R.id.button)
        viewPager = view.findViewById(R.id.view_pager)

        button.setOnClickListener {
            val lastItem = viewPager.adapter?.itemCount ?: 0
            val currentItem = viewPager.currentItem

            if (currentItem < lastItem) {
                viewPager.setCurrentItem((currentItem + 1), true)
            }
        }

        liveData.observe(viewLifecycleOwner, Observer { bundle ->
            val text = bundle?.getString(BaseOrderFragment.BUTTON_TEXT)
            button.text = text

            val currentFragmentType = bundle?.getString(CURRENT_FRAGMENT_TYPE)
            val selectedOption = bundle?.getString(SELECTED_OPTION)
            val nextFragment = bundle?.getString(NEXT_FRAGMENT)

            when (nextFragment) {
                "loadImage" -> adapter.add(LoadImageFragment())
                "selectType" -> adapter.add(SelectTypeFragment())
                "address" -> adapter.add(AddressFragment())
                "final" -> adapter.add(FinalFragment())
            }
        })


        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when (position) {
//                    0 -> toolbarProgress.setProgress(30, 0, 100)
//                    1 -> toolbarProgress.setProgress(75, 0, 100)
                }
            }
        })


    }

    companion object {
        private const val CURRENT_FRAGMENT_TYPE = "currentFragmentType"
        private const val SELECTED_OPTION = "selectedOption"
        private const val NEXT_FRAGMENT = "nextFragment"
    }


}