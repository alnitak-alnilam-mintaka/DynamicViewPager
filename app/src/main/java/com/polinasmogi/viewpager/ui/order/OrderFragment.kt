package com.polinasmogi.viewpager.ui.order

import android.os.Bundle
import androidx.lifecycle.MutableLiveData

interface OrderFragment {
    fun generateNextFragment(): OrderFragment
    fun bindData(data: MutableLiveData<Bundle>)
}