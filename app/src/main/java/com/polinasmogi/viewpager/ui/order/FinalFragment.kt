package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.viewpager.databinding.FragmentFinalBinding
import com.polinasmogi.viewpager.databinding.FragmentSelectTypeBinding

class FinalFragment: Fragment(), OrderFragment {

    private lateinit var viewModel: OrderViewModel

    var liveData: MutableLiveData<Bundle>? = null

    private var _binding: FragmentFinalBinding? = null
    private val binding get() = _binding!!

    private var checkedId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        _binding = FragmentFinalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun generateNextFragment(): OrderFragment {
        TODO("Not yet implemented")
    }

    override fun bindData(data: MutableLiveData<Bundle>) {
        liveData = data
    }
}