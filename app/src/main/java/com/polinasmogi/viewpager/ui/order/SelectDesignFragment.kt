package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.polinasmogi.viewpager.R
import com.polinasmogi.viewpager.databinding.FragmentSelectDesignBinding

class SelectDesignFragment: BaseOrderFragment(), OrderFragment {

    private lateinit var viewModel: OrderViewModel

    var liveData: MutableLiveData<Bundle>? = null

    private var _binding: FragmentSelectDesignBinding? = null
    private val binding get() = _binding!!

    private var checkedId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        _binding = FragmentSelectDesignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        liveData?.let { data ->
            binding.radioGroup.setOnCheckedChangeListener { _, id ->
                var buttonText = ""
                var nextFragment = ""
                when (id) {
                    R.id.base_cover_radio_button -> {
                        buttonText = "Выбрать тип книги"
                        nextFragment = "selectType"
                    }
                    R.id.custom_cover_radio_button -> {
                        buttonText = "Выбрать обложку"
                        nextFragment = "loadImage"
                    }
                }
                val bundle = Bundle()
                bundle.putString(BUTTON_TEXT, buttonText)
                bundle.putString(NEXT_FRAGMENT, nextFragment)
                data.postValue(bundle)
            }

        }

    }

    override fun generateNextFragment(): OrderFragment {
        return when (checkedId) {
            R.id.base_cover_radio_button -> SelectTypeFragment()
            R.id.custom_cover_radio_button -> LoadImageFragment()
            else -> this
        }
    }

    override fun bindData(data: MutableLiveData<Bundle>) {
        liveData = data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}