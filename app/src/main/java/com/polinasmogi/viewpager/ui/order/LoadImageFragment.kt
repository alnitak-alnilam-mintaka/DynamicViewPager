package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.viewpager.R
import com.polinasmogi.viewpager.databinding.FragmentLoadImageBinding
import com.polinasmogi.viewpager.databinding.FragmentSelectDesignBinding

class LoadImageFragment: Fragment(), OrderFragment  {

    private lateinit var viewModel: OrderViewModel

    var liveData: MutableLiveData<Bundle>? = null

    private var _binding: FragmentLoadImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        _binding = FragmentLoadImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun generateNextFragment(): OrderFragment {
        TODO("Not yet implemented")
    }

    override fun bindData(data: MutableLiveData<Bundle>) {
        liveData = data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}