package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData

class AddressFragment: Fragment(), OrderFragment  {

    var liveData: MutableLiveData<Bundle>? = null

    override fun generateNextFragment(): OrderFragment {
        TODO("Not yet implemented")
    }

    override fun bindData(data: MutableLiveData<Bundle>) {
        liveData = data
    }

}